package com.example.kotlinpractice.kotlin

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.kotlinpractice.R
import com.example.kotlinpractice.databinding.ActivityRoomInKotlinBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class RoomInKotlinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomInKotlinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomInKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this //LiveData를 활용하기 위해

        //val viewModel = ViewModelProvider(this).get(RoomInKotlinViewModel::class.java)
        val viewModel: RoomInKotlinViewModel by viewModels()
        
        binding.viewModel = viewModel //bingding객체에 view 모델 주입
        
        //binding 객체에 viewmodel을 주입하므로써 아래의 코드는 xml에서 대체 가능
//        viewModel.getAll().observe(this, Observer {
//            //데이터가 변경될때마다 불리는 scope
//            binding.resultText.text = it.toString()
//        })

        findViewById<View>(R.id.add_button).setOnClickListener { v: View? ->
            lifecycleScope.async(Dispatchers.Default) { //Dispatchers.io workerThread로 정의
                //이 scope에 있는 로직들은 mainThread가 아닌 다른 workThread에서 동작함
                viewModel.insert(Todo(binding.todoEdit.text.toString()))
            }
        }
    }
}
