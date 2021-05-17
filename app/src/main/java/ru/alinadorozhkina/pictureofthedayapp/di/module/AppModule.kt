package ru.alinadorozhkina.pictureofthedayapp.di.module

import dagger.Module
import dagger.Provides
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.App

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App = app
}