package ru.alinadorozhkina.pictureofthedayapp.mvp.model.repo

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.alinadorozhkina.pictureofthedayapp.BuildConfig
import ru.alinadorozhkina.pictureofthedayapp.api.PictureOfTheDayAPI
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.network.INetWorkStatus
import java.lang.RuntimeException

val apiKey: String = BuildConfig.NASA_API_KEY

class PictureRepo(
    val api: PictureOfTheDayAPI,
    val netWorkStatus: INetWorkStatus
) : IPictureRepo {

    override fun getPicture() = netWorkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getPictureOfTheDay(apiKey)
        } else {
            throw RuntimeException("Отсутствует доступ в интернет")
        }
    }.subscribeOn(Schedulers.io())

}