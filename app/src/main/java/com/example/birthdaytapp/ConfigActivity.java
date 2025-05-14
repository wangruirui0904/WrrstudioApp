package com.example.birthdaytapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfigActivity extends AppCompatActivity {

    private static final String TAG ="Rate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_config);
        //接受参数
        Intent intent =getIntent();

        float dollar2 =intent.getFloatExtra("dollar_rate_key",1.1f);
        float euro2 =intent.getFloatExtra("euro_rate_key",2.2f);
        float won2 =intent.getFloatExtra("won_rate_key",3.3f);

        Log.i(TAG, "clickOpen: dollar2="+dollar2);
        Log.i(TAG, "clickOpen: euro2="+euro2);
        Log.i(TAG, "clickOpen: won2="+won2);




    }
}