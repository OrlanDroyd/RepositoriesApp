package com.gmail.orlandroyd.repositoriesapp

import android.os.CountDownTimer

class CustomCountdown(
    private val onTick: ((currentValue: Int) -> Unit),
    private val onFinish: (() -> Unit),
) {

    var timer: InternalTimer = InternalTimer(
        onTick = onTick,
        onFinish = onFinish,
        millisInFuture = 60000,
        countDownInterval = 1000
    )

    fun stop() {
        timer.cancel()
    }

    class InternalTimer(
        private val onTick: ((currentValue: Int) -> Unit),
        private val onFinish: (() -> Unit),
        millisInFuture: Long,
        countDownInterval: Long
    ) : CountDownTimer(
        millisInFuture,
        countDownInterval
    ) {
        init {
            this.start()
        }

        override fun onFinish() {
            onFinish.invoke()
        }

        override fun onTick(millisUntilFinished: Long) {
            onTick(millisUntilFinished.toInt())
        }
    }
}