package ru.alinadorozhkina.pictureofthedayapp.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(
    @Expose val date: String,
    @Expose val explanation: String,
    @Expose val hdurl: String,
    @Expose val title: String
): Parcelable