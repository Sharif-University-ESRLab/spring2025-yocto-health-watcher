FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://wpa_supplicant.conf"
SRC_URI += "file://heartbeat_module.conf"

do_install:append() {
    install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}/etc/wpa_supplicant.conf
    install -m 0644 ${WORKDIR}/heartbeat_module.conf ${D}/etc/modules-load.d/heartbeat_module.conf
}

