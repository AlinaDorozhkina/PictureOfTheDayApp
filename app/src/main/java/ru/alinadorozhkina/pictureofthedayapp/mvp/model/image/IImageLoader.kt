package ru.alinadorozhkina.pictureofthedayapp.mvp.model.image

interface IImageLoader <T> {
    fun load(url: String, container: T)
}