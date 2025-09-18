FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://heartbeat_module.c \
            file://Makefile" \
            SRC_URI += "file://heartbeat.cfg"

do_kernel_configme:append() {
    echo "CONFIG_HEARTBEAT_MODULE=y" >> ${B}/.config
}
