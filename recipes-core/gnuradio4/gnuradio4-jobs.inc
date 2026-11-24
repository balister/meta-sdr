# Size upstream's ninja job pools from both PARALLEL_MAKE and the build
# host's memory.
#
# The gnuradio4 test translation units are very large: on aarch64 with
# full debug info, gnuradio4-core's qa_SchedulerLifecycle.cpp peaks at
# 7.4 GB and gnuradio4-blocks' qa_SoapyIntegration.cpp at 5.0 GB. Sizing
# the pools from PARALLEL_MAKE alone ran a 32 GB, 12-core CI builder out
# of memory (cc1plus killed, or a crashed assembler leaving a bad object
# file that later fails to link).
#
# gr4_jobs(d, gb) returns min(PARALLEL_MAKE, MemTotal / gb), at least 1.
# The signature hashes this code, not the number it returns, so hosts
# with different core counts or memory still share sstate.
def gr4_jobs(d, gb_per_job):
    import oe.utils
    jobs = oe.utils.parallel_make(d) or 1
    try:
        with open("/proc/meminfo") as f:
            for line in f:
                if line.startswith("MemTotal:"):
                    mem_kb = int(line.split()[1])
                    jobs = min(jobs, mem_kb // (gb_per_job * 1024 * 1024))
                    break
    except (OSError, ValueError):
        pass
    return max(1, jobs)
