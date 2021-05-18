package ru.alinadorozhkina.pictureofthedayapp.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.entity.Picture

interface PictureOfTheDayAPI {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Single<Picture>
}
