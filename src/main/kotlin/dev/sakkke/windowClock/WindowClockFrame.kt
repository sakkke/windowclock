package dev.sakkke.windowClock

import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.swing.JFrame
import javax.swing.WindowConstants

class WindowClockFrame : JFrame() {
    companion object {
        lateinit var instance: WindowClockFrame
            private set
    }

    init {
        instance = this

        setSize(300, 100)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        this.updateCurrentTime()
        isResizable = false
        isVisible = true
    }

    private fun getCurrentTime(): String {
        val currentTime = LocalTime.now()
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        return currentTime.format(formatter)
    }

    fun updateCurrentTime() {
        this.title = this.getCurrentTime()
    }
}