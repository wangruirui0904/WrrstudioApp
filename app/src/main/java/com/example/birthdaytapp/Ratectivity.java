package com.example.birthdaytapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Ratectivity extends AppCompatActivity {

    private static final String TAG ="Rate";
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
        Intent config = new Intent(this,ConfigActivity.class);
        //传递参数
        config.putExtra("dollar_rate_key",dollarRate);
        config.putExtra("euro_rate_key",euroRate);
        config.putExtra("won_rate_key",wonRate);

        Log.i(TAG, "clickOpen: dollarRate="+dollarRate);
        Log.i(TAG, "clickOpen: euroRate="+euroRate);
        Log.i(TAG, "clickOpen: wonRate="+wonRate);

        //startActivity(config);

        startActivityForResult(config,3);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==3 && resultCode==6){
            Bundle bdl = data.getExtras();
            dollarRate = bdl.getFloat("key_dollar2");
            euroRate = bdl.getFloat("key_euro2");
            wonRate = bdl.getFloat("key_won2");
            Log.i(TAG, "onActivityResult= "+dollarRate);
        }
        super.onActivityResult(requestCode,resultCode,data);
    }


}