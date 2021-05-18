package ru.alinadorozhkina.pictureofthedayapp.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.alinadorozhkina.pictureofthedayapp.api.PictureOfTheDayAPI
import ru.alinadorozhkina.pictureofthedayapp.di.SuperScope
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.network.INetWorkStatus
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.App
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.network.AndroidNetWorkStatus


@Module
class ApiModule {
    @SuperScope
    @Provides
    fun api(gson: Gson): PictureOfTheDayAPI = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(PictureOfTheDayAPI::class.java)

    @SuperScope
    @Provides
    fun gson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @SuperScope
    @Provides
    fun networkStatus(app: App): INetWorkStatus = AndroidNetWorkStatus(app)
}