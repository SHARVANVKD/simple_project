package com.example.project.Home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_Users";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Tbl_user_details";

    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_PWD = "pwd";

    public DBHandler(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT,"
                + COL_PWD + " TEXT)";
        sqLiteDatabase.execSQL(query);
    }
    public void addNewUser(String UserName, String Password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NAME, UserName);
        values.put(COL_PWD, Password);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery(
                "select * from Tbl_user_details where name=? and pwd=? ",new String[]{username,password});
        if (cursorCourses.getCount() > 0 ) {
            return true;
        }else{
            return false;
        }

    }
}
