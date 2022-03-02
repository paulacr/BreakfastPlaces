package com.paulacr.breakfastplaces.data.model

import androidx.annotation.IntRange

data class PlaceDto(val id: String, val name: String, val visitedCount: Int = 0, @IntRange(from = 1, to = 5) val rating: Int)
