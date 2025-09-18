#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>
#include <linux/timer.h>

static struct timer_list heartbeat_timer;
static unsigned int interval = 3;

static void heartbeat_fn(struct timer_list *t) {
    printk(KERN_INFO "heartbeat: alive\n");
    mod_timer(&heartbeat_timer, jiffies + interval * HZ);
}

static int __init heartbeat_init(void) {
    timer_setup(&heartbeat_timer, heartbeat_fn, 0);
    mod_timer(&heartbeat_timer, jiffies + interval * HZ);
    printk(KERN_INFO "heartbeat module loaded\n");
    return 0;
}

static void __exit heartbeat_exit(void) {
    del_timer_sync(&heartbeat_timer);
    printk(KERN_INFO "heartbeat module unloaded\n");
}

module_init(heartbeat_init);
module_exit(heartbeat_exit);

MODULE_LICENSE("GPL");
