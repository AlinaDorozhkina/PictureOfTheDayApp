package ru.alinadorozhkina.pictureofthedayapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.navigation.IScreens
import ru.alinadorozhkina.pictureofthedayapp.mvp.view.MainView
import javax.inject.Inject

class MainPresenter: MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.picture())
    }
}