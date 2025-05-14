package com.example.birthdaytapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfigActivity extends AppCompatActivity {

    private static final String TAG ="Rate";
    private EditText dollarText;
    private EditText euroText;
    private EditText wonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        //接受参数
        Intent intent = getIntent();
        float dollar2 = intent.getFloatExtra("dollar_rate_key", 0.0f);
        float euro2 = intent.getFloatExtra("euro_rate_key", 0.0f);
        float won2 = intent.getFloatExtra("won_rate_key", 0.0f);
        Log.i(TAG, "clickOpen: dollar2=" + dollar2);
        Log.i(TAG, "clickOpen: euro2=" + euro2);
        Log.i(TAG, "clickOpen: won2=" + won2);
        //将数据收入页面控件里
        dollarText = findViewById(R.id.dollar_edit);
        euroText = findViewById(R.id.euro_edit);
        wonText = findViewById(R.id.won_edit);

        dollarText.setText(String.valueOf(dollar2));
        euroText.setText(String.valueOf(euro2));
        wonText.setText(String.valueOf(won2));
    }

    public void save (View btn){
        Log.i(TAG, "save: ");
        //获取重新输入的值
        String dollarStr = dollarText.getText().toString();
        String euroStr = euroText.getText().toString();
        String wonStr = wonText.getText().toString();
        //带回数据
        Intent intent = getIntent();
        Bundle bundle = new Bundle();
        bundle.putFloat("key_dollar2",Float.parseFloat(dollarStr));
        bundle.putFloat("key_euro2",Float.parseFloat(euroStr));
        bundle.putFloat("key_won2",Float.parseFloat(wonStr));
        intent.putExtras(bundle);
        setResult(6,intent);

        finish();

    }
}




