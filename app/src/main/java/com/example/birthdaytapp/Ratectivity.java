package com.example.birthdaytapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ratectivity extends AppCompatActivity {

    TextView show;
    private float dollarRate=0.1f;
    private float euroRate=0.05f;
    private float wonRate=500f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratectivity);
        show=findViewById(R.id.rmb_show);
    }
    public void click(View btn){
        //获取输入数据
        EditText input =findViewById(R.id.rmb);
        String inpStr=input.getText().toString();
        try {
            float rmb = Float.parseFloat(inpStr);
            float result = 0.0f;
            //计算
            if (btn.getId() == R.id.btn_dollar) {

                result = rmb * dollarRate;
            } else if (btn.getId() == R.id.btn_euro) {

                result = rmb * euroRate;
            } else if (btn.getId() == R.id.btn_won) {


                result = rmb * wonRate;
            }

            //输出
            show.setText(String.valueOf(result));
        }catch(NumberFormatException ex){
            show.setText("请输入正确数据");
            Toast.makeText(this, "请输入正确数据", Toast.LENGTH_LONG).show();
        }

    }
    public void clickOpen(View btn){
        //打开新的窗口
        //Intent main = new Intent(this,MainActivity.class);
        //startActivity(main);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:87092173"));
        startActivity(intent);
    }
    public void click5(View btn)
    {
//        Intent intentPhone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:87092173"));
//        startActivity(intentPhone);
        Intent jdintent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.jd.com"));
        startActivity(jdintent);
    }
}