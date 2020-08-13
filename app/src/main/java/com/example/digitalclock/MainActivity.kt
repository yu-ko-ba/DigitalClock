package com.example.digitalclock

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

//class MainActivity : AppCompatActivity() {
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // アプリをフルスクリーンで起動するための処理
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        // 現在時刻を表示する処理
        val handler = Handler()
        timer(period = 100) {
            val calendar = Calendar.getInstance()
            val hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
            val minute = String.format("%02d", calendar.get(Calendar.MINUTE))

            handler.post {
                time.text = "${hour}:${minute}"
            }
        }
    }
}