package com.etcxy.prats.delete_sqlhelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datalist);

        MyOpenHelper oh = new MyOpenHelper(this);
        SQLiteDatabase db = oh.getWritableDatabase();

        personList = new ArrayList<>();

        Cursor cursor = db.query("person", null, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String salary = cursor.getString(cursor.getColumnIndex("salary"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));

            Person person = new Person(id, name, salary, phone);

            personList.add(person);
        }

        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);

        for (Person p : personList) {
            TextView tv = new TextView(this);
            tv.setText(p.toString());
            tv.setTextSize(13);
            ll.addView(tv);
        }


    }
}
