package com.example.kotlinpractice.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.kotlinpractice.R
import com.example.kotlinpractice.databinding.ActivityRoomInKotlinBinding
import com.example.kotlinpractice.java.AppDatabase
import com.example.kotlinpractice.java.Todo

class RoomInKotlinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomInKotlinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomInKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = Room.databaseBuilder(this, AppDatabase::class.java, "todo-db-ko")
            .allowMainThreadQueries() // 해당 옵션은 메인쓰레드에서 db조작 할수 있도록 해주는 메소드 실무에서는 쓰이지 않음
            .build() //데이터 베이스 생성

        db.todoDao().all.observe(this,
            { todos: List<Todo?> ->  //todoDao().getAll()은 LiveData로 감싸져 있으므로 관찰(observe)이 가능함
                //데이터가 변경될때마다 불리는 scope
                binding.resultText.text = todos.toString()
            })

        binding.resultText.text = db.todoDao().all.toString()

        findViewById<View>(R.id.add_button).setOnClickListener { v: View? ->
            db.todoDao()
                .insert(Todo(binding.todoEdit.text.toString()))
        }
    }
}