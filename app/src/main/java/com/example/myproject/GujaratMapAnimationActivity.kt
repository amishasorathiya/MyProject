package com.example.myproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class GujaratMapAnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gujarat_map_animation)

        var iv = findViewById<ImageView>(R.id.imageView3)

        var b1 = findViewById<Button>(R.id.button)
        b1.setOnClickListener {
            var an = AnimationUtils.loadAnimation(applicationContext, R.anim.spin)
            iv.startAnimation(an)
        }

        var b2 = findViewById<Button>(R.id.button2)
        b2.setOnClickListener {
            var an = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom)
            iv.startAnimation(an)
        }

        var b3 = findViewById<Button>(R.id.button3)
        b3.setOnClickListener {
            var an = AnimationUtils.loadAnimation(applicationContext, R.anim.move)
            iv.startAnimation(an)
        }

        var b4 = findViewById<Button>(R.id.button4)
        b4.setOnClickListener {
            var an = AnimationUtils.loadAnimation(applicationContext, R.anim.blink)
            iv.startAnimation(an)
        }

        var b5 = findViewById<Button>(R.id.button5)
        b5.setOnClickListener {
            var an = AnimationUtils.loadAnimation(applicationContext, R.anim.all_animations)
            iv.startAnimation(an)
        }
    }
}