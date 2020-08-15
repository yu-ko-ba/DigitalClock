package com.example.digitalclock

import android.app.Activity
//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.timer

// Activityクラスを継承すると、上の方にアプリ名が出なくなる
//class MainActivity : AppCompatActivity() {
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // アプリをフルスクリーンで起動するための処理
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)

        // 現在時刻を表示する処理
        // Handlerクラスのインスタンスを取得しておく
        val handler = Handler()
        // 0.1秒ごとに現在時刻を取得する
        timer(period = 100) {
            // 現在時刻を取得する
            val calendar = Calendar.getInstance()
            // 時間を取り出す（24時間表記）
            val hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
            // 分を取り出す
            val minute = String.format("%02d", calendar.get(Calendar.MINUTE))

            // 画面の表示はメインスレッドからしか変えられないから、メインスレッドで実行する
            handler.post {
                // IDが time のtextViewの表示する文字として hour定数の中身 + ":" + minute定数の中身 をセットする
                time.text = "${hour}:${minute}"
            }
        }
    }
}