package ru.alinadorozhkina.pictureofthedayapp.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.alinadorozhkina.pictureofthedayapp.di.SuperScope
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.App
import javax.inject.Named

@Module
class AppModule(val app: App) {

    @Provides
    fun app(): App = app

    @Named("ui-thread")
    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()
}