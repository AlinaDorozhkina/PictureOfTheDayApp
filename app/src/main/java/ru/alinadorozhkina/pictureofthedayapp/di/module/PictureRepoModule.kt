package ru.alinadorozhkina.pictureofthedayapp.di.module

import dagger.Module
import dagger.Provides
import ru.alinadorozhkina.pictureofthedayapp.api.PictureOfTheDayAPI
import ru.alinadorozhkina.pictureofthedayapp.di.SuperScope
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.network.INetWorkStatus
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.repo.IPictureRepo
import ru.alinadorozhkina.pictureofthedayapp.mvp.model.repo.PictureRepo

@Module
class PictureRepoModule {
    @SuperScope
    @Provides
    fun picture(
        api: PictureOfTheDayAPI,
        networkStatus: INetWorkStatus
    ):
            IPictureRepo = PictureRepo(api, networkStatus)
}