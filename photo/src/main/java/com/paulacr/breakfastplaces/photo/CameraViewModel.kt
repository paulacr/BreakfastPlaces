package com.paulacr.breakfastplaces.photo

import androidx.lifecycle.ViewModel
import com.paulacr.breakfastplaces.boundary.db.BreakfastDb
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(
    private val breakfastDb: BreakfastDb,
) : ViewModel() {
    fun hello() {
        breakfastDb.hello()
    }
}