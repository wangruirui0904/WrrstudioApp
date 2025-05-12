package com.example.birthdaytapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView out, result;

    EditText inph, inpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Log.i("main", "Message");
        out = findViewById(R.id.txtout);
        result = findViewById(R.id.result);
        inph = findViewById(R.id.inph);
        inpw = findViewById(R.id.inpw);

    }

    public void onClickBtn(View view) {
        Log.i("main", "onClickBtn: ");
        String heightstr = inph.getText().toString();
        String weightstr = inpw.getText().toString();
        if (heightstr != null && heightstr.length() > 0 && weightstr != null && weightstr.length() > 0) {
            float height = Float.parseFloat(heightstr);
            float weight = Float.parseFloat(weightstr);
            float bmi = weight * 10000 / (height * height);
            if (bmi < 18) {
                result.setText("偏轻,加强营养" + String.format("%.2f", bmi));
            } else if (bmi < 24) {
                result.setText("正常" + String.format("%.2f", bmi));
            } else if (bmi < 28) {
                result.setText("偏重" + String.format("%.2f", bmi));
            } else {
                result.setText("超重" + String.format("%.2f", bmi));
            }
        }else{
            result.setText("请输入正确的数据");
        }
    }
}