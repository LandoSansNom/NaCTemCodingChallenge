package com.example.nactemcodingchallenge.di

import com.example.nactemcodingchallenge.data.remote.ApiCall
import com.example.nactemcodingchallenge.data.remote.ApiDetails
import com.example.nactemcodingchallenge.data.repository.Repository
import com.example.nactemcodingchallenge.data.repository.RepositoryImp
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideOkHttpInstance(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient() // Set Gson to be lenient if required
            .create()
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideAPI(
        retrofit: Retrofit
    ): ApiCall {
        return retrofit.create(ApiCall::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        apiCall: ApiCall,
    ): Repository {
        return RepositoryImp(apiCall)
    }


}