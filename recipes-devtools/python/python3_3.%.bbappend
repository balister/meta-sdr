# Create symlink at the end of do_install
do_install_append() {
    ln -s -r ${D}/${bindir}/python3 ${D}/${bindir}/python
}

# Include the symlink in the python3-core package
FILES_${PN}-core += "${D}/${bindir}/python"
