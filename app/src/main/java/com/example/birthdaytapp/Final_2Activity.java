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
    }
}

