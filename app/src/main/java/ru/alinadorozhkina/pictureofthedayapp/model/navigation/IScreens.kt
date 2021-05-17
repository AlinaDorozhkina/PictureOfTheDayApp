package ru.alinadorozhkina.pictureofthedayapp.model.navigation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun description(): Screen
    fun picture(): Screen
}