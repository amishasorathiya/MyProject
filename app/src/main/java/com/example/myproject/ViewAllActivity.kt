package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class ViewAllActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_all)

        var helper = MyHelper(applicationContext)
        var db = helper.readableDatabase
        var lv = findViewById<ListView>(R.id.listview)
        var rs = db.rawQuery("SELECT _id, DISTRICT_NAME, CODE FROM DISTRICT",null)
        var adapter = SimpleCursorAdapter(applicationContext,
            R.layout.mylistlayout,
            rs,

            arrayOf("DISTRICT_NAME","CODE"),

            intArrayOf(R.id.textView3, R.id.textView4),
            0)
        lv.adapter = adapter


    }
}