package ru.alinadorozhkina.pictureofthedayapp.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.alinadorozhkina.pictureofthedayapp.model.PODServerResponseData

interface PictureOfTheDayAPI {
    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<PODServerResponseData>
}
