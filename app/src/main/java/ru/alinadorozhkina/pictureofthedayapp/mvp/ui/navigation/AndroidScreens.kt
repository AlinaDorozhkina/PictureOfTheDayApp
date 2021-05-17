package ru.alinadorozhkina.pictureofthedayapp.mvp.ui.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.alinadorozhkina.pictureofthedayapp.model.navigation.IScreens
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.fragments.PicFragment

class AndroidScreens: IScreens {
    override fun description(): Screen {
        TODO("Not yet implemented")
    }

    override fun picture(): Screen = FragmentScreen {PicFragment.newInstance()}
}