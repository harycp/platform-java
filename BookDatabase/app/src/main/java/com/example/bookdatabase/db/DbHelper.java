package com.example.bookdatabase.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bookdatabase.model.Book;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "dbbooks";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STD = "books";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_WRITER = "writer";
    private static final String KEY_PAGES = "pages";

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STD + " (" +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_TITLE + " TEXT, " +
            KEY_WRITER + " TEXT, " +
            KEY_PAGES + " INTEGER);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_STD + "'");
        onCreate(db);
    }

    public long addUserDetail(String title, String writer, Integer pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, title);
        values.put(KEY_WRITER, writer);
        values.put(KEY_PAGES, pages);
        long insert = db.insert(TABLE_STD, null, values);
        return insert;
    }

    public ArrayList<Book> getAllUsers() {
        ArrayList<Book> userModelArrayList = new
                ArrayList<Book>();
        String selectQuery = "SELECT * FROM " + TABLE_STD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Book std = new Book();
                std.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                std.setTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
                std.setWriter(c.getString(c.getColumnIndex(KEY_WRITER)));
                std.setPages(c.getInt(c.getColumnIndex(KEY_PAGES)));
                // adding to Book list
                userModelArrayList.add(std);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STD, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }

    public int updateUser(int id, String title, String writer, Integer pages) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, title);
        values.put(KEY_WRITER, writer);
        values.put(KEY_PAGES, pages);
        return db.update(TABLE_STD, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
}
