package ru.alinadorozhkina.pictureofthedayapp.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.entity.Picture

interface IPictureRepo {
    fun getPicture(): Single<Picture>
}