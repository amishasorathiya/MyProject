package com.example.myproject

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class BeachAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beach_animation)

        var ad = AnimationDrawable()
        var frame1 = resources.getDrawable(R.drawable.a,null)
        var frame2 = resources.getDrawable(R.drawable.b,null)
        var frame3 = resources.getDrawable(R.drawable.c,null)
        var frame4 = resources.getDrawable(R.drawable.d,null)
        var frame5 = resources.getDrawable(R.drawable.e,null)
        var frame6 = resources.getDrawable(R.drawable.f,null)
        var frame7 = resources.getDrawable(R.drawable.g,null)

        ad.addFrame(frame1,200)
        ad.addFrame(frame2,200)
        ad.addFrame(frame3,200)
        ad.addFrame(frame4,200)
        ad.addFrame(frame5,200)
        ad.addFrame(frame6,200)
        ad.addFrame(frame7,200)

        var iv = findViewById<ImageView>(R.id.imageView2)
        iv.background = ad
        ad.start()

    }
}