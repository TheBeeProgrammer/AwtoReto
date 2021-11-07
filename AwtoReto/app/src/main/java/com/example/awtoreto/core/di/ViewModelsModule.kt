package com.example.awtoreto.core.di

import com.example.awtoreto.data.JokeRepositoryImpl
import com.example.awtoreto.domain.repositories.JokeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import io.reactivex.disposables.CompositeDisposable

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ViewModelsModule {

    @Binds
    abstract fun bindJokeRepository(repository: JokeRepositoryImpl): JokeRepository

    companion object {
        @Provides
        fun provideCompositeDisposable() = CompositeDisposable()
    }
}