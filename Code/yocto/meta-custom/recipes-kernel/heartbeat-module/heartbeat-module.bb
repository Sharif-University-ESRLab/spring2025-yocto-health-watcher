DESCRIPTION = "Heartbeat Kernel Module"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${THISDIR}/files/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://heartbeat_module.c \
           file://Makefile"

S = "${WORKDIR}"

inherit module

MODULES_INSTALL_TARGET = "modules_install"

do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake KERNEL_SRC=${STAGING_KERNEL_DIR} \
               KERNEL_VERSION=${KERNEL_VERSION} \
               CROSS_COMPILE=${TARGET_PREFIX} \
               ARCH=${ARCH}
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 heartbeat_module.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
}
