package com.paulacr.breakfastplaces.db.di

import com.paulacr.breakfastplaces.db.BreakfastDb
import com.paulacr.breakfastplaces.db.BreakfastDbImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DbModule {
    @Binds
    abstract fun bindDb(breakfastDbImpl: BreakfastDbImpl): BreakfastDb
}