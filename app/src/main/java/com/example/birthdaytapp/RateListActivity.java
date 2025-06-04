package com.example.birthdaytapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RateListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //准备数据
        String[] data ={"hello","android","studio","listview"};

        //构造适配器
        ListAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,data);

         //绑定
        setListAdapter(adapter);
    }
}