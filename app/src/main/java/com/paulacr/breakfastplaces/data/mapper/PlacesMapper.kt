package com.paulacr.breakfastplaces.data.mapper

import com.paulacr.breakfastplaces.data.model.PlaceDto
import com.paulacr.breakfastplaces.domain.model.Place

object PlacesMapper {

    fun map(places: List<Place>, visitedCount: Int, rating: Int): List<PlaceDto> {
        return places.map {
            PlaceDto(
                id = it.id,
                name =  it.name,
                visitedCount = visitedCount,
                rating = rating)
        }
    }
}