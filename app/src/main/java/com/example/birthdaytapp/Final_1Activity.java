package com.example.birthdaytapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Final_1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final1);

        // 绑定按钮
        Button btn_Enter = findViewById(R.id.btn_enter);

        // 设置点击事件
        btn_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View btn) {
                // 创建 Intent 跳转到 Final2Activity
                Intent intent = new Intent(Final_1Activity.this, Final_2Activity.class);
                startActivity(intent);
            }
        });
    }
}



