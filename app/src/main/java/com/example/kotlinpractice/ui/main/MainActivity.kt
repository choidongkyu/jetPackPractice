package com.example.kotlinpractice.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinpractice.R

//코틀린의 상속 - 일반적인 extends인 경우 클래스 뒤에 ()와 같은 괄호가 붘음
//ex MainActivity : AppCompatActivity()
//그러나 interface를 상속 받는 경우에는 괄호를 붙이지 않음!
//ex MainActivity : View.OnClickListener
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}