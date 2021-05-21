package ru.alinadorozhkina.pictureofthedayapp.mvp.model.navigation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun picture(): Screen
    fun home(): Screen
    fun settings(): Screen
}