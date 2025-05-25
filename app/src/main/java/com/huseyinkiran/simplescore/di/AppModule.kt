package com.huseyinkiran.simplescore.di

import com.huseyinkiran.simplescore.utils.Constants.API_KEY
import com.huseyinkiran.simplescore.utils.Constants.BASE_URL
import com.huseyinkiran.simplescore.data.api.FootballApi
import com.huseyinkiran.simplescore.data.repository.FootballRepositoryImpl
import com.huseyinkiran.simplescore.domain.repository.FootballRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @[Singleton Provides]
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("content-type", "application/json")
                .addHeader("authorization", API_KEY)
                .build()
            chain.proceed(request)
        }
            .build()
    }

    @[Singleton Provides]
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @[Singleton Provides]
    fun provideFootballServiceApi(retrofit: Retrofit): FootballApi {
        return retrofit.create(FootballApi::class.java)
    }

    @[Singleton Provides]
    fun provideFootballRepository(api: FootballApi): FootballRepository = FootballRepositoryImpl(api)

}