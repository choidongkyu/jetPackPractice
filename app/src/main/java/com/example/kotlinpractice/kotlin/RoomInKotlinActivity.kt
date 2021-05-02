package com.example.kotlinpractice.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.kotlinpractice.R
import com.example.kotlinpractice.databinding.ActivityRoomInKotlinBinding
import com.example.kotlinpractice.java.AppDatabase
import com.example.kotlinpractice.java.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class RoomInKotlinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomInKotlinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomInKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = Room.databaseBuilder(this, AppDatabase::class.java, "todo-db-ko")
            .build() //데이터 베이스 생성

        db.todoDao().all.observe(this,
            { todos: List<Todo?> ->  //todoDao().getAll()은 LiveData로 감싸져 있으므로 관찰(observe)이 가능함
                //데이터가 변경될때마다 불리는 scope
                binding.resultText.text = todos.toString()
            })

        binding.resultText.text = db.todoDao().all.toString()

        findViewById<View>(R.id.add_button).setOnClickListener { v: View? ->
            lifecycleScope.async(Dispatchers.IO) { //Dispatchers.io workerThread로 정의
                //이 scope에 있는 로직들은 mainThread가 아닌 다른 workThread에서 동작함
                db.todoDao().insert(Todo(binding.todoEdit.text.toString()))
            }
        }
    }
}