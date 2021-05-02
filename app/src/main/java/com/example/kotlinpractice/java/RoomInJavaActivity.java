package com.example.kotlinpractice.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
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


        RoomInJavaViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RoomInJavaViewModel.class);


        viewModel.getAll().observe(this, todos -> { //todoDao().getAll()은 LiveData로 감싸져 있으므로 관찰(observe)이 가능함
            //데이터가 변경될때마다 불리는 scope
            mResultTextView.setText(todos.toString());
        });

        findViewById(R.id.add_button).setOnClickListener(v -> {
            viewModel.insert(new Todo(mTodoEditText.getText().toString()));
        });

    }
}