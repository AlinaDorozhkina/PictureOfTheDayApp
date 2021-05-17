package ru.alinadorozhkina.pictureofthedayapp.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import ru.alinadorozhkina.pictureofthedayapp.model.navigation.IScreens
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.navigation.AndroidScreens
import javax.inject.Singleton

@Module
class CiceroneModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    fun router(): Router = cicerone.router

    @Provides
    fun screens(): IScreens = AndroidScreens()
}