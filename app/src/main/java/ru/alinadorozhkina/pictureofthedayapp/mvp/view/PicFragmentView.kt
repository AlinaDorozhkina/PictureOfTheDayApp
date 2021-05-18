package ru.alinadorozhkina.pictureofthedayapp.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface PicFragmentView: MvpView {
    fun setData(data: String)
    fun loadPicture(url: String)
    fun error(message: String)
}