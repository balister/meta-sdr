# Add a timestamp to the image in /etc/version-image

add_image_version_info() {
	touch ${IMAGE_ROOTFS}/etc/version-image
	echo "Timestamp:" `date -u +%4Y%2m%2d%2H%2M` >> ${IMAGE_ROOTFS}/etc/version-image
	echo "Release: ${RELEASE_NAME}" >> ${IMAGE_ROOTFS}/etc/version-image 
	echo "Image: ${PN}" >> ${IMAGE_ROOTFS}/etc/version-image 
}

ROOTFS_POSTPROCESS_COMMAND += "add_image_version_info ; "

