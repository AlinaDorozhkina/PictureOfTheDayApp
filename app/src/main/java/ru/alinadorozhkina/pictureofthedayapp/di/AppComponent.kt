package ru.alinadorozhkina.pictureofthedayapp.di

import dagger.Component
import ru.alinadorozhkina.pictureofthedayapp.di.module.ApiModule
import ru.alinadorozhkina.pictureofthedayapp.di.module.AppModule
import ru.alinadorozhkina.pictureofthedayapp.di.module.CiceroneModule
import ru.alinadorozhkina.pictureofthedayapp.mvp.presenter.MainPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.presenter.PicFragmentPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.activities.MainActivity

@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CiceroneModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(picFragmentPresenter: PicFragmentPresenter)
}
