package com.example.birthdaytapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Calendar;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "exchange_rates.db";
    private static final int DB_VERSION = 1;

    // 表名和列名
    public static final String TABLE_RATES = "rates";
    public static final String COL_CURRENCY = "currency";
    public static final String COL_RATE = "rate";
    public static final String COL_LAST_UPDATED = "last_updated";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建表
        String createTable = "CREATE TABLE " + TABLE_RATES + " (" +
                COL_CURRENCY + " TEXT PRIMARY KEY, " +
                COL_RATE + " REAL, " +
                COL_LAST_UPDATED + " INTEGER)"; // 时间戳（毫秒）
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATES);
        onCreate(db);
    }

    // 插入或更新汇率
    public void insertOrUpdateRate(String currency, float rate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_CURRENCY, currency);
        values.put(COL_RATE, rate);
        values.put(COL_LAST_UPDATED, Calendar.getInstance().getTimeInMillis());
        db.replace(TABLE_RATES, null, values);
        db.close();
    }

    // 获取某货币的汇率和最后更新时间
    public Cursor getRate(String currency) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(
                TABLE_RATES,
                new String[]{COL_RATE, COL_LAST_UPDATED},
                COL_CURRENCY + " = ?",
                new String[]{currency},
                null, null, null
        );
    }

    // 检查是否需要更新（是否为当天）
    public boolean isUpdateNeeded(long lastUpdatedTime) {
        Calendar lastUpdate = Calendar.getInstance();
        lastUpdate.setTimeInMillis(lastUpdatedTime);

        Calendar today = Calendar.getInstance();
        return lastUpdate.get(Calendar.YEAR) != today.get(Calendar.YEAR) ||
                lastUpdate.get(Calendar.MONTH) != today.get(Calendar.MONTH) ||
                lastUpdate.get(Calendar.DAY_OF_MONTH) != today.get(Calendar.DAY_OF_MONTH);
    }
}