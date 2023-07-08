package com.paulacr.breakfastplaces.db

import timber.log.Timber
import javax.inject.Inject

class BreakfastDbImpl @Inject constructor(): BreakfastDb {
    override fun hello() {
        Timber.d("qwerty hello!")
    }
}