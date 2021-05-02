package com.example.kotlinpractice.kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity //데이터 베이스의 데이터의 역할을 하기위해서는 Entity 어노테이션을 붙여줘야함
data class Todo(@PrimaryKey(autoGenerate = true) val id:Int, var title: String)
