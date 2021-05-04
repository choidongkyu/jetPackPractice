package com.example.kotlinpractice.java;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

public class RoomInJavaViewModel extends AndroidViewModel { //context가 필요한 경우에는 AndroidViewModel 을 상속
    private AppDatabase db;
    private HandlerThread handlerThread;
    private Handler handler;
    public LiveData<List<Todo>> todos;

    public RoomInJavaViewModel(@NonNull Application application) {
        super(application);
        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db")
                .build(); //데이터 베이스 생성

        handlerThread = new HandlerThread("db-thread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());

        todos = getAll();
    }

    public LiveData<List<Todo>> getAll() {
        Log.d("test11", "getall called");
        return db.todoDao().getAll();
    }

    public void insert(Todo todo) {
        handler.post(() -> {
            db.todoDao().insert(todo);
        });
    }
}
