package com.example.birthdaytapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Final_2_2_1 extends AppCompatActivity {

    private EditText etTitle, etContent, etTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final221);
        // 初始化视图
        etTitle = findViewById(R.id.et_title);
        etContent = findViewById(R.id.et_content);
        etTime = findViewById(R.id.et_time);
        Button btnSave = findViewById(R.id.btn_save);
        Button btnCancel = findViewById(R.id.btn_cancel);

        // 保存按钮点击事件
        btnSave.setOnClickListener(v -> saveMemo());

        // 取消按钮点击事件
        btnCancel.setOnClickListener(v -> finish());
    }

    private void saveMemo() {
        String title = etTitle.getText().toString().trim();
        String content = etContent.getText().toString().trim();
        String time = etTime.getText().toString().trim();

        // 简单验证输入
        if (title.isEmpty()) {
            etTitle.setError("请输入标题");
            return;
        }

        if (time.isEmpty()) {
            etTime.setError("请输入时间");
            return;
        }

        // 返回数据给列表页面
        Intent resultIntent = new Intent();
        resultIntent.putExtra("title", title);
        resultIntent.putExtra("content", content);
        resultIntent.putExtra("time", time);
        setResult(RESULT_OK, resultIntent);
        finish(); // 关闭当前页面

    }
}






