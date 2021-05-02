package com.example.kotlinpractice.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kotlinpractice.R;

import java.util.List;

public class RoomInJavaActivity extends AppCompatActivity {

    private EditText mTodoEditText;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_in_java);
        mTodoEditText = findViewById(R.id.todo_edit);
        mResultTextView = findViewById(R.id.result_text);

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db")
                .allowMainThreadQueries() // 해당 옵션은 메인쓰레드에서 db조작 할수 있도록 해주는 메소드 실무에서는 쓰이지 않음
                .build(); //데이터 베이스 생성

        db.todoDao().getAll().observe(this, todos -> { //todoDao().getAll()은 LiveData로 감싸져 있으므로 관찰(observe)이 가능함
            //데이터가 변경될때마다 불리는 scope
            mResultTextView.setText(todos.toString());
        });

        mResultTextView.setText(db.todoDao().getAll().toString());

        findViewById(R.id.add_button).setOnClickListener(v ->
                db.todoDao().insert(new Todo(mTodoEditText.getText().toString())));
    }
}