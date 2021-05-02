package com.example.kotlinpractice.kotlin

import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): List<Todo>

    @Insert
    fun insert(todo:Todo)

    @Delete
    fun delete(todo:Todo)

    @Update
    fun update(todo:Todo)
}