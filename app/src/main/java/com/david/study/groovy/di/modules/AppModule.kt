package com.david.study.groovy.di.modules

import com.david.study.groovy.interfaces.PlaylistApi
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.service.PlaylistService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(
    FragmentComponent::class,
    ViewModelComponent::class,
)
class AppModule {

    @Provides
    fun providePlaylistRepository(service: PlaylistService) : PlaylistRepository = PlaylistRepository(service)

    @Provides
    fun providePlaylistService(api: PlaylistApi): PlaylistService = PlaylistService(api)

    @Provides
    fun provideApi(retrofit: Retrofit): PlaylistApi = retrofit.create(PlaylistApi::class.java)

    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://localhost:3000")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}