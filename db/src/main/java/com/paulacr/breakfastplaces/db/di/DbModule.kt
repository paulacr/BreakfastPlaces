package com.paulacr.breakfastplaces.db.di

import com.paulacr.breakfastplaces.boundary.db.BreakfastDb
import com.paulacr.breakfastplaces.db.BreakfastDbImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DbModule {
    @Provides
    fun provideDb(): BreakfastDb = BreakfastDbImpl()
}