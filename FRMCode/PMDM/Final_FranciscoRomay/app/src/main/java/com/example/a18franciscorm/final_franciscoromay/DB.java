package com.example.a18franciscorm.final_franciscoromay;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by a18franciscorm on 14/03/2019.
 */

public class DB extends SQLiteOpenHelper {
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Compostos(nome text primary key, formula text);");
        db.execSQL("insert into Compostos(nome, formula) values('Ácido súlfurico','SO4H2');");
        db.execSQL("insert into Compostos(nome, formula) values('Auga','H2O');");
        db.execSQL("insert into Compostos(nome, formula) values('Carbonato Cálcico','CO3CA');");
        db.execSQL("insert into Compostos(nome, formula) values('Anhídrico carbónico','CO2');");
        db.execSQL("insert into Compostos(nome, formula) values('Monóxido de carbono','CO');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist Compostos;");
        db.execSQL("create table Compostos(nome text primary key, formula text);");
        db.execSQL("insert into Compostos(nome, formula) values('Ácido súlfurico','SO4H2');");
        db.execSQL("insert into Compostos(nome, formula) values('Auga','H2O');");
        db.execSQL("insert into Compostos(nome, formula) values('Carbonato Cálcico','CO3CA');");
        db.execSQL("insert into Compostos(nome, formula) values('Anhídrico carbónico','CO2');");
        db.execSQL("insert into Compostos(nome, formula) values('Monóxido de carbono','CO');");
    }

}
