package com.example.a18franciscorm.proxecto;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a18franciscorm on 21/02/2019.
 */

public class ClaseDB extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE Alimentos (codigo INTEGER PRIMARY KEY, nombre TEXT, tipo text)";
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
