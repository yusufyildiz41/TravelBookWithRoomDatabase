package com.yusufyildiz.travelbooknew.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yusufyildiz.travelbooknew.model.Place
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao //Data Access Objects
interface PlaceDao {
    @Query("SELECT * FROM Place")
    fun getAll() : Flowable<List<Place>> //Flowable Rx Java

    @Insert
    fun insert(place : Place) : Completable //Completable Rx Java

    @Delete
    fun delete(place : Place) : Completable


}