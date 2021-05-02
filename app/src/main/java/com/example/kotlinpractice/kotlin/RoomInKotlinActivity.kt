package com.example.kotlinpractice.kotlin

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kotlinpractice.R
import com.example.kotlinpractice.java.AppDatabase
import com.example.kotlinpractice.java.Todo

class RoomInKotlinActivity : AppCompatActivity() {
    private var mTodoEditText: EditText? = null
    private var mResultTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_in_kotlin)

        mTodoEditText = findViewById<EditText>(R.id.todo_edit)
        mResultTextView = findViewById<TextView>(R.id.result_text)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "todo-db-ko")
            .allowMainThreadQueries() // 해당 옵션은 메인쓰레드에서 db조작 할수 있도록 해주는 메소드 실무에서는 쓰이지 않음
            .build() //데이터 베이스 생성

    }
}