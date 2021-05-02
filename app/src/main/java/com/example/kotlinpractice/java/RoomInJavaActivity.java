package com.example.kotlinpractice.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
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

        HandlerThread handlerThread = new HandlerThread("db-thread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());

        AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db")
                .build(); //데이터 베이스 생성

        db.todoDao().getAll().observe(this, todos -> { //todoDao().getAll()은 LiveData로 감싸져 있으므로 관찰(observe)이 가능함
            //데이터가 변경될때마다 불리는 scope
            mResultTextView.setText(todos.toString());
        });

        mResultTextView.setText(db.todoDao().getAll().toString());

        findViewById(R.id.add_button).setOnClickListener(v ->
                handler.post(() -> {
                    db.todoDao().insert(new Todo(mTodoEditText.getText().toString()));
                }));

    }
}