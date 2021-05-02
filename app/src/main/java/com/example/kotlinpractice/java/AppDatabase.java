package com.example.kotlinpractice.java;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.kotlinpractice.java.Todo;
import com.example.kotlinpractice.java.TodoDao;


@Database(entities = {Todo.class}, version = 1) //데이터 베이스 객체로 만들기 위한 어노테이션
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
}
