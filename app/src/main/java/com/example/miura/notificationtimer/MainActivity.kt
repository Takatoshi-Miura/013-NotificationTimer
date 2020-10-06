package com.example.miura.notificationtimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 変数の宣言
        var menuButton = findViewById<ImageButton>(R.id.menuButton)
        var cameraButton = findViewById<ImageButton>(R.id.cameraButton)
        var soundButton = findViewById<ImageButton>(R.id.soundButton)
        var startButton = findViewById<ImageButton>(R.id.startButton)
        var resetButton = findViewById<ImageButton>(R.id.resetButton)

        // メニューボタンの処理
        menuButton.setOnClickListener{
            Log.d("TAG", "メニューボタンが押されました")
        }

        // カメラボタンの処理
        cameraButton.setOnClickListener{
            Log.d("TAG", "カメラボタンが押されました")
        }

        // サウンドボタンの処理
        soundButton.setOnClickListener{
            Log.d("TAG", "サウンドボタンが押されました")
        }

        // スタートボタンの処理
        startButton.setOnClickListener{
            Log.d("TAG", "スタートボタンが押されました")
        }

        // リセットボタンの処理
        resetButton.setOnClickListener{
            Log.d("TAG", "リセットボタンが押されました")
        }

    }
}
