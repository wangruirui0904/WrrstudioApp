package com.example.birthdaytapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    private static final String TAG ="ScoreActivity";
    private int score1=0;
    private int score2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
    }
    public void clicka(View btn){
        Log.i(TAG, "clicka: 1111");
        if(btn.getId()==R.id.btn_1){
            score1+=3;
        }else if(btn.getId()==R.id.btn_2){
            score1 +=2;
        }else{
            score1 +=1;
        }
        show(R.id.score1,score1);

    }
    public void clickb(View btn) {
        Log.i(TAG, "clickb:222");
        if (btn.getId() == R.id.btn_4) {
            score2 += 3;
        } else if (btn.getId() == R.id.btn_5) {
            score2 += 2;
        } else {
            score2 += 1;
        }
        show(R.id.score2, score2);
    }
    private void show(int p,int score){
        TextView s=findViewById(p);
        s.setText(String.valueOf(score));
    }
    public void reset(View btn) {
        Log.i(TAG, "reset");

        score1 = 0;
        score2 = 0;
        show(R.id.score1, score1);
        show(R.id.score2, score2);
    }



}