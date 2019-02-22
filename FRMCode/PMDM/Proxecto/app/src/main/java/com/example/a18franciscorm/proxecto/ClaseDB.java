package com.example.a18franciscorm.proxecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a18franciscorm on 21/02/2019.
 */

public class ClaseDB extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Alimentos (codigo INTEGER PRIMARY KEY, nombre TEXT, tipo TEXT,azucares TEXT, grasas TEXT, sodio TEXT);";

    public ClaseDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Alimentos;");
        db.execSQL(sqlCreate);
    }
}
