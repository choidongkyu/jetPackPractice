package com.example.kotlinpractice.java;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.kotlinpractice.java.Todo;

import java.util.List;

//DAO - Data Access Object의 약자로, 데이터베이스의 데이터에 접근하기 위해 생성하는 객체이다.
//데이터베이스에 접근하기 위한 로직과 비즈니스 로직을 분리하기 위해 사용한다.
//간단하게 DB에 접속하여 데이터의 crud 작업을 시행하는 클래스라고 생각하면 됨
@Dao
public interface TodoDao {
    @Query("SELECT * FROM Todo")
    // todo 테이블의 모든 데이터를 가져오는 메소드
    LiveData<List<Todo>> getAll(); //LiveDAta 키워드로 감싸게 되면 해당 데이터는 관찰 가능한 data가 됨.

    @Insert
    void insert(Todo todo); // 데이터를 넣기 위한 메소드

    @Update
    void update(Todo todo);

    @Delete
    void delete(Todo todo);
}