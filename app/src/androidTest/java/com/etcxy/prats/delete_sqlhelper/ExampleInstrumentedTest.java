package com.etcxy.prats.delete_sqlhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.test.InstrumentationRegistry;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleInstrumentedTest {

    private SQLiteDatabase db;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.etcxy.prats.delete_sqlhelper", appContext.getPackageName());
    }

    @Test
    public void insert() {
        db.execSQL("insert into person(name,salary,phone) values ('小智','1234','1231')");
    }

    @Test
    public void delete() {
        db.execSQL("delete from person where name = ?", new Object[]{"xiaozhi"});
    }

    @Test
    public void update() {
        db.execSQL("update person...");
    }

    @Test
    public void query() {
        Cursor cursor = db.rawQuery("select * from person", null);
        while (cursor.moveToNext()) {

            int columnCount = cursor.getColumnCount();

            String _id = cursor.getString(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String salary = cursor.getString(cursor.getColumnIndex("salary"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            Log.v("info", "columnCount:" + columnCount);
            Log.v("info", _id + ":" + name + ": " + salary + ": " + phone + ".......");

        }
    }

    @Before
    public void setUp() {
        Log.i("test", "setUp");
        MyOpenHelper oh = new MyOpenHelper(InstrumentationRegistry.getTargetContext(), "people.db", null, 1);
        db = oh.getWritableDatabase();
    }

    @After
    public void tearDown() {
        db.close();
    }

    @Test
    public void insertApi() {
        for (int i = 0; i < 50; i++) {

            ContentValues cv = new ContentValues();
            cv.put("name", "No." + i);
            cv.put("salary", 1000 + i + "");
            cv.put("phone", "123" + i + "00");
            db.insert("person", null, cv);
        }

    }

    @Test
    public void deleteApi() {
        int row = db.delete("person", "name = ? and _id = ?", new String[]{"小智", "10"});

    }

    @Test
    public void updateApi() {
        ContentValues cv = new ContentValues();
        cv.put("salary", "1000000");
        db.update("person", cv, "name = ?", new String[]{"猪油"});
    }

    @Test
    public void transaction() {

        try {
            db.beginTransaction();
            ContentValues cv = new ContentValues();
            cv.put("salary", "100");
            db.update("person", cv, "name = ?", new String[]{"猪油"});

            cv.clear();
            cv.put("salary", "100000");
            db.update("person", cv, "name = ?", new String[]{"小智"});

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
