package com.baosystems.icrc.psm.service.scheduler

import io.reactivex.schedulers.Schedulers

class TrampolineSchedulerProvider: BaseSchedulerProvider {
    override fun computation() = Schedulers.trampoline()
    override fun io() = Schedulers.trampoline()
    override fun ui() = Schedulers.trampoline()
}