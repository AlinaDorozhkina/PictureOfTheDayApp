package ru.alinadorozhkina.pictureofthedayapp.mvp.model.network

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface INetWorkStatus {
        fun isOnline(): Observable<Boolean>
        fun isOnlineSingle(): Single<Boolean>
}