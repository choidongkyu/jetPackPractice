package com.example.kotlinpractice.java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kotlinpractice.R;
import com.example.kotlinpractice.databinding.ActivityRoomInJavaBinding;

public class RoomInJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRoomInJavaBinding binding = ActivityRoomInJavaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setLifecycleOwner(this);//binding 객체가 현재 액티비티의 라이프 사이클을 따르게함


        RoomInJavaViewModel viewModel = new ViewModelProvider(this,
                new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RoomInJavaViewModel.class);

        binding.setViewModel(viewModel); //binding 객체에 view모델 주입 xml에서 view모델을 쓸수 있게 됨.


        //데이타 바인딩에 viewmodel을 주입시켰으므로 불필요한 코드가 됨
//        viewModel.getAll().observe(this, todos -> { //todoDao().getAll()은 LiveData로 감싸져 있으므로 관찰(observe)이 가능함
//            //데이터가 변경될때마다 불리는 scope
//            binding.resultText.setText(todos.toString());
//        });

        findViewById(R.id.add_button).setOnClickListener(v -> {
            viewModel.insert(new Todo(binding.todoEdit.getText().toString()));
        });

    }
}