package com.example.kotlinpractice.kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.kotlinpractice.kotlin.AppDatabase

class RoomInKotlinViewModel(application: Application) : AndroidViewModel(application) {
    private var db: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "todo-db-ko")
        .build()


    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    suspend fun insert(todo: Todo) { //suspend 키워드가 붙은 함수는 무조건 코루틴 내부에서 돌아야함
        db.todoDao().insert(todo)
    }
}