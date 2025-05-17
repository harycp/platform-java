package com.example.ourgroups.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ourgroups.model.Group;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "dbkelompok";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STD = "groups";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_NIM = "nim";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_KELOMPOK = "kelompok";
    private static final String KEY_APLIKASI = "aplikasi";

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STD + " (" +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " TEXT, " +
            KEY_NIM + " TEXT, " +
            KEY_EMAIL + " TEXT, " +
            KEY_KELOMPOK + " TEXT, " +
            KEY_APLIKASI + " TEXT);";

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

    public long addUserDetail(String name, String nim, String email, String kelompok, String aplikasi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_NIM, nim);
        values.put(KEY_EMAIL, email);
        values.put(KEY_KELOMPOK, kelompok);
        values.put(KEY_APLIKASI, aplikasi);
        long insert = db.insert(TABLE_STD, null, values);
        return insert;
    }

    public ArrayList<Group> getAllUsers() {
        ArrayList<Group> userModelArrayList = new
                ArrayList<Group>();
        String selectQuery = "SELECT * FROM " + TABLE_STD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                Group std = new Group();
                std.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                std.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                std.setNim(c.getString(c.getColumnIndex(KEY_NIM)));
                std.setEmail(c.getString(c.getColumnIndex(KEY_EMAIL)));
                std.setKelompok(c.getString(c.getColumnIndex(KEY_KELOMPOK)));
                std.setAplikasi(c.getString(c.getColumnIndex(KEY_APLIKASI)));
                // adding to Group list
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

    public int updateUser(int id, String name, String nim, String email, String kelompok, String aplikasi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_NIM, nim);
        values.put(KEY_EMAIL, email);
        values.put(KEY_KELOMPOK, kelompok);
        values.put(KEY_APLIKASI, aplikasi);
        return db.update(TABLE_STD, values, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
    }
}
