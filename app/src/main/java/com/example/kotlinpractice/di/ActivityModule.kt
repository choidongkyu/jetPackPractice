package com.example.kotlinpractice.di

import com.example.kotlinpractice.di.qualifier.ActivityHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
object ActivityModule {
    @ActivityHash
    @Provides
    fun provideHash() = hashCode().toString()
}