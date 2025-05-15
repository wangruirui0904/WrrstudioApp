package com.example.birthdaytapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetActivity extends AppCompatActivity implements Runnable {

    private static final String TAG = "Net";
    Handler handler;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        show = findViewById(R.id.net_show);

        handler = new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                //处理返回
                if (msg.what == 5) {
                    String str = (String) msg.obj;
                    Log.i(TAG, "handleMessage: str=" + str);
                    show.setText(str);

                }
                super.handleMessage(msg);
            }

        };


        Thread t = new Thread(this);
        t.start();
    }

    public void onClick(View btn){
        Log.i(TAG, "onClic");
        Thread t = new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        Log.i(TAG, "run: 子线程（）.....");

        //获网络数据
        URL url = null;
        String html="";
        try {
            url = new URL("https://www.boc.cn/sourcedb/whpj/");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            InputStream in = http.getInputStream();

            html = inputStream2String(in);
            Log.i(TAG, "run: html=" + html);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //发送消息
        Message msg = handler.obtainMessage(5,html );
        handler.sendMessage(msg);
    }

    private String inputStream2String(InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream, "utf-8");
        while (true) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();


    }
}
