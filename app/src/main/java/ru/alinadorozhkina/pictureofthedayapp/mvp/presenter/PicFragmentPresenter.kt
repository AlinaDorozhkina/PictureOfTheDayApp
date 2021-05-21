package ru.alinadorozhkina.pictureofthedayapp.mvp.presenter

import android.util.Log
import android.widget.ImageView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.image.IImageLoader
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.navigation.IScreens
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.repo.IPictureRepo
import ru.alinadorozhkina.pictureofthedayapp.mvp.view.PicFragmentView
import javax.inject.Inject
import javax.inject.Named

class PicFragmentPresenter : MvpPresenter<PicFragmentView>() {
    val tag = PicFragmentPresenter::class.simpleName
    @Inject
    lateinit var pictureRepo: IPictureRepo

    @field:Named("ui-thread")
    @Inject lateinit var uiScheduler: Scheduler

    @Inject lateinit var router: Router

    @Inject lateinit var loader: IImageLoader<ImageView>
    @Inject  lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        Log.v(tag,"onFirstViewAttach()")
        super.onFirstViewAttach()
        pictureRepo.getPicture()
            .observeOn(uiScheduler)
            .subscribe({ picture ->
                Log.v(tag, picture.toString())
                viewState.setData(picture.date)
                viewState.setTitle(picture.title)
                viewState.loadPicture(picture.hdurl)
                viewState.setDescription(picture.explanation)

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

    fun homeClicked(){
        router.navigateTo(screens.home())
    }
}