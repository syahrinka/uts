package com.example.katalogkebaya.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasekatalog extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "databasekatalog.db";
    private static final int DATABASE_VERSION = 1;
    private String sql;

    public databasekatalog(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create database table notekatalogkebaya
        sql = "create table notekatalogkebaya(no integer primary key AUTOINCREMENT, jeniskebaya text null, modelkebaya text null, deskripsi text null);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }
}


