package com.example.kotlinpractice.ui.second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinpractice.R
import com.example.kotlinpractice.ui.data.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    @Inject
    lateinit var repository: MyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}