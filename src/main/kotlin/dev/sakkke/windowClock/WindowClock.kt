package dev.sakkke.windowClock

import org.quartz.CronScheduleBuilder
import org.quartz.JobBuilder
import org.quartz.TriggerBuilder
import org.quartz.impl.StdSchedulerFactory

fun main() {
    WindowClockFrame()

    val schedulerFactory = StdSchedulerFactory()
    val scheduler = schedulerFactory.scheduler
    scheduler.start()
    val windowClockJob = JobBuilder.newJob(WindowClockJob::class.java)
        .withIdentity("windowClockJob", "main")
        .build()
    val secondlyTrigger = TriggerBuilder.newTrigger()
        .withIdentity("hourlyTrigger", "main")
        .startNow()
        .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
        .forJob("windowClockJob", "main")
        .build()
    scheduler.scheduleJob(windowClockJob, secondlyTrigger)
}