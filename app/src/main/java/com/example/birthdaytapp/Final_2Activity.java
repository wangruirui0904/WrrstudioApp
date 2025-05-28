package com.example.birthdaytapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Final_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);
        Button button2 = findViewById(R.id.button_2);
        button2.setOnClickListener(v -> {
            // 创建 Intent 跳转到 Final_2Activity
            Intent intent = new Intent(Final_2Activity.this, Final_2_1Activity.class);
            startActivity(intent);
        });
        // 初始化按钮3并设置跳转到Final_2_2Activity
        Button button3 = findViewById(R.id.button_3);
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(Final_2Activity.this, Final_2_2Activity.class);
            startActivity(intent);
    });
        Button button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(v -> {
            Intent intent = new Intent(Final_2Activity.this, Final_2_3Activity.class);
            startActivity(intent);
        });
        Button button5 = findViewById(R.id.button_5);
        button5.setOnClickListener(v -> {
            Intent intent = new Intent(Final_2Activity.this, Final_2_4Activity.class);
            startActivity(intent);
        });

    }
}

