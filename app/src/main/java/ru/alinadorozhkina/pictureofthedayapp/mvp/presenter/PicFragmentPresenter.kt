package ru.alinadorozhkina.pictureofthedayapp.mvp.presenter

import android.widget.ImageView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.image.IImageLoader
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.repo.IPictureRepo
import ru.alinadorozhkina.pictureofthedayapp.mvp.view.PicFragmentView
import javax.inject.Inject
import javax.inject.Named

class PicFragmentPresenter : MvpPresenter<PicFragmentView>() {

    @Inject
    lateinit var pictureRepo: IPictureRepo

    @field:Named("ui-thread")
    @Inject lateinit var uiScheduler: Scheduler

    @Inject lateinit var loader: IImageLoader<ImageView>

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        pictureRepo.getPicture()
            .observeOn(uiScheduler)
            .subscribe({ picture ->
                viewState.setData(picture.date)
                viewState.loadPicture(picture.hdurl)

            }, {
                viewState.error(it.message.toString())
            })
    }

    fun favouritesClicked() {
        TODO("Not yet implemented")
    }

    fun settingsClicked() {
        TODO("Not yet implemented")
    }

    fun seaarchClicked() {
        TODO("Not yet implemented")
    }
}