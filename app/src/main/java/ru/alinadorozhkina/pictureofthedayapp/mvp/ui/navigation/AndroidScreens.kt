package ru.alinadorozhkina.pictureofthedayapp.mvp.ui.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.navigation.IScreens
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.fragments.BottomNavigationDrawerFragment
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.fragments.PicFragment
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.fragments.SettingsFragment

class AndroidScreens: IScreens {
    override fun picture(): Screen = FragmentScreen {PicFragment.newInstance()}
    override fun home(): Screen = FragmentScreen {BottomNavigationDrawerFragment.newInstance()}
    override fun settings(): Screen = FragmentScreen{SettingsFragment.newInstance()}
}