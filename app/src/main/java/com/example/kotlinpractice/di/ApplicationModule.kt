package com.example.kotlinpractice.di

import com.example.kotlinpractice.di.qualifier.AppHash
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {
    @AppHash
    @Provides
    fun provideHash() = hashCode().toString()
}