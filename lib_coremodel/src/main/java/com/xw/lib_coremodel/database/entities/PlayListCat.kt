package com.xw.lib_coremodel.database.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "my_playList_cat")
data class PlayListCat(
    @PrimaryKey
    val name: String,
    val resourceCount: Int = 0,
    val category: Int,
    val hot: Boolean = false,
    var isDisable: Boolean = false,
    //常驻的
    var isResident: Boolean = false
) : Parcelable
