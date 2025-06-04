package com.example.birthdaytapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class RateActivity extends AppCompatActivity {

    private static final String TAG = "Rate";
    TextView show;
    private float dollarRate = 0.1f;
    private float euroRate = 0.05f;
    private float wonRate = 500f;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        show = findViewById(R.id.rmb_show);
    }

    SharedPreferences sharedPreferences = getSharedPreferences("myrate", Activity.MODE_PRIVATE);
    dollarRate =sharedPreferences.getFLoat("dollar_23rate",0.1f);
    euroRate =sharedPreferences.getFLoat("euro_23rate",0.2f);
    wonRate =sharedPreferences.getFLoat("won_23rate",123.0f);

    handler =new Handler(Looper.myLooper()){

        @Override
        public void handleMessage(@NonNull Message msg){
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

    public void click(View btn) {
        //获取输入数据
        EditText input = findViewById(R.id.rmb);
        String inpStr = input.getText().toString();
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
        } catch (NumberFormatException ex) {
            show.setText("请输入正确数据");
            Toast.makeText(this, "请输入正确数据", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void run() {
        Log.i(TAG, "run: 子线程（）.....");

        //获网络数据
        URL url = null;
        String html = "";
               try {
                   Document doc = Jsoup.connect("https://www.boc.cn/sourcedb/whpj/").get();
          Element table = doc.getElementsByTagName("table").first();
            Elements rows = table.getElementsByTagName("tr");
            rows.remove(0);
            for (Element row : rows) {
                Elements tds = row.getElementsByTagName("td");
               Element td1 = tds.first();
               Element td2 = tds.get(4);
               log.i(TAG, "run td1=" + td1.text() + "->" + td2.text());
                html += (td1.text() + "=>" + td2.text() + "\n");
            }
            Element td = doc.select("body>main>div.Lt.dh>div.hlb>div.hlb_lt>table>tbody>tr:nth-child(7)")

    } catch (MalformedURLException e) {
            e.printStackTrace();
                    } catch (IOException e) {
       e.printStackTrace();
       }






    public void clickOpen(View btn) {
        openConfigActivity();
    }

    private void openConfigActivity() {
        //打开新的窗口
        Intent config = new Intent(this, ConfigActivity.class);
        //传递参数
        config.putExtra("dollar_rate_key", dollarRate);
        config.putExtra("euro_rate_key", euroRate);
        config.putExtra("won_rate_key", wonRate);

        Log.i(TAG, "clickOpen: dollarRate=" + dollarRate);
        Log.i(TAG, "clickOpen: euroRate=" + euroRate);
        Log.i(TAG, "clickOpen: wonRate=" + wonRate);

        //startActivity(config);

        startActivityForResult(config, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 3 && resultCode == 6) {
            Bundle bdl = data.getExtras();
            dollarRate = bdl.getFloat("key_dollar2");
            euroRate = bdl.getFloat("key_euro2");
            wonRate = bdl.getFloat("key_won2");
            Log.i(TAG, "onActivityResult= " + dollarRate);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_set) {
            openConfigActivity();

            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}