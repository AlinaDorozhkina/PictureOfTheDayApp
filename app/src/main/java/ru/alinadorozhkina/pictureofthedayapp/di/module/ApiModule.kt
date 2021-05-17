package ru.alinadorozhkina.pictureofthedayapp.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alinadorozhkina.pictureofthedayapp.api.PictureOfTheDayAPI
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun api(gson: Gson): PictureOfTheDayAPI = Retrofit.Builder()
        .baseUrl("https://api.deezer.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(PictureOfTheDayAPI::class.java)

    @Singleton
    @Provides
    fun gson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()
}