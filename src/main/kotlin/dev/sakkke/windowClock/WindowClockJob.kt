package dev.sakkke.windowClock

import org.quartz.Job
import org.quartz.JobExecutionContext

class WindowClockJob : Job {
    override fun execute(p0: JobExecutionContext?) {
        WindowClockFrame.instance.updateCurrentTime()
    }
}