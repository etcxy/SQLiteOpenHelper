package com.etcxy.prats.delete_sqlhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by etcxy@live.cn on 2017/8/28.
 */

public class MyOpenHelper extends SQLiteOpenHelper {


    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.v("info", "MyopenHelper run");
    }
    public MyOpenHelper(Context context) {
        super(context, "people.db", null, 1);
        Log.v("info", "MyopenHelper run");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.v("info", "database creata");
        db.execSQL("create table person (_id integer primary key autoincrement,name char(10),salary char(20) ,phone integer(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.v("info", "databases update");
    }

}
