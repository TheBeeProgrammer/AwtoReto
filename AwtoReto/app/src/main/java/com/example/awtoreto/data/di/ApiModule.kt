package com.example.awtoreto.data.di

import com.example.awtoreto.data.api.AnyJokeApi
import com.example.awtoreto.data.api.ApiConstants
import com.example.awtoreto.data.api.interceptors.NetworkStatusInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApi(okHttpClient: OkHttpClient): AnyJokeApi {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_ENDPOINT)
            .client(okHttpClient).addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnyJokeApi::class.java)
    }

    @Provides
    fun provideOkHttpClient(
        networkStatusInterceptor: NetworkStatusInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkStatusInterceptor)
            .build()
    }
}