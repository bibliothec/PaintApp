package com.example.paintapp

import android.graphics.Color
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity() : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //アプリの名前を消す
        supportActionBar?.hide()
        //Viewとボタンの取得
        val myView =findViewById<MyView>(R.id.myView)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnRed = findViewById<ImageButton>(R.id.redColor)
        val btnBlue = findViewById<ImageButton>(R.id.blueColor)
        val btnBlack = findViewById<ImageButton>(R.id.blackColor)
        val eraser = findViewById<ImageButton>(R.id.whiteColor)
        //クリア処理
        btnClear.setOnClickListener {
            myView.clearCanvas()
        }
        //色の変更
        btnRed.setOnClickListener {
            Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show()
            myView.currentBrush = Color.RED
            myView.path = Path()
        }

        btnBlue.setOnClickListener {
            Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
            myView.currentBrush = Color.BLUE
            myView.path = Path()
        }

        btnBlack.setOnClickListener {
            Toast.makeText(this, "Black", Toast.LENGTH_SHORT).show()
            myView.currentBrush = Color.BLACK
            myView.path = Path()
        }

        eraser.setOnClickListener {
            Toast.makeText(this, "Eraser", Toast.LENGTH_SHORT).show()
            myView.currentBrush = Color.WHITE
            myView.path = Path()
        }
    }
}
