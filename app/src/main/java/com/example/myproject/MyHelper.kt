package com.example.myproject

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context:Context?) : SQLiteOpenHelper(context,"DistrictCodeDb",null,1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE DISTRICT(_id INTEGER PRIMARY KEY AUTOINCREMENT, DISTRICT_NAME TEXT, CODE TEXT)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}