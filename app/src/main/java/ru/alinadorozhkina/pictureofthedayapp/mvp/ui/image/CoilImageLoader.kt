package ru.alinadorozhkina.pictureofthedayapp.mvp.ui.image

import android.widget.ImageView
import coil.api.load
import ru.alinadorozhkina.pictureofthedayapp.R
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.image.IImageLoader

class CoilImageLoader : IImageLoader<ImageView> {
    override fun load(url: String, container: ImageView) {
        container.load(url) {
            placeholder(R.drawable.nopicture)
        }
    }
}