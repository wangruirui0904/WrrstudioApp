package com.example.birthdaytapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView out;
    EditText inp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        out = (TextView) findViewById(R.id.showText);
        inp =(EditText) findViewById(R.id.inputText);

        Button btn =(Button) findViewById(R.id.btn1);
                //btn.setOnClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("mail", "onClick called...");
                String str=inp.getText().toString();

                out.setText("Hello" + str);
            }
        });
    }
    @Override
    public void onClick(View v) {
        Log.i("click", "onClick... ");
        //TextView tv = (TextView) findViewById(R.id.showText);
        //EditText inp =(EditText) findViewById(R.id.inputText);
        String str=inp.getText().toString();

        out.setText("Hello" + str);
    }
}