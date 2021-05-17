package ru.alinadorozhkina.pictureofthedayapp.mvp.ui

import android.app.Application
import ru.alinadorozhkina.pictureofthedayapp.di.AppComponent
import ru.alinadorozhkina.pictureofthedayapp.di.DaggerAppComponent
import ru.alinadorozhkina.pictureofthedayapp.di.module.AppModule

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}