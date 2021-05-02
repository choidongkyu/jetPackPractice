package com.example.kotlinpractice.kotlin

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>> //LiveData 키워드로 감싸게 되면 해당 데이터는 관찰 가능한 data가 됨.


    @Insert
    fun insert(todo: Todo)

    @Delete
    fun delete(todo: Todo)

    @Update
    fun update(todo: Todo)
}