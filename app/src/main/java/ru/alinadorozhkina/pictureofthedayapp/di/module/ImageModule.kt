package ru.alinadorozhkina.pictureofthedayapp.di.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.alinadorozhkina.pictureofthedayapp.di.SuperScope
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.image.IImageLoader
import ru.alinadorozhkina.pictureofthedayapp.mvp.ui.image.CoilImageLoader

@Module
class ImageModule {

    @SuperScope
    @Provides
    fun load(): IImageLoader<ImageView> = CoilImageLoader()
}