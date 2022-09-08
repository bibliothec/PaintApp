package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class MyView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    // 線,図形,グラフィック描画等
    var path: Path = Path()
    // 色,太さ等
    var paintBrush: Paint = Paint()
    // タッチした位置を示す
    var drawX: Float= 0F
    var drawY: Float= 0F
    // パスと色の配列
    var pathList = ArrayList<Path>()
    var colorList = ArrayList<Int>()
    // 現在の色
    var currentBrush = Color.BLACK

    //２）onDraw(描画の準備)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paintBrush.style= Paint.Style.STROKE
        paintBrush.isAntiAlias = true
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 20F
        for(i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas?.drawPath(pathList[i],paintBrush)
            invalidate()
        }
    }

    //実際の描画（押した時、動かした時）
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        //タッチした位置（x座標、y座標）
        if (event != null) {
            drawX = event.x
            drawY = event.y
            when(event.action){
                // 書き始め
                MotionEvent.ACTION_DOWN -> path.moveTo(drawX,drawY)
                // 書き終わり
                MotionEvent.ACTION_MOVE -> {
                    path.lineTo(drawX,drawY)
                    pathList.add(path)
                    colorList.add(currentBrush)
                }
            }
        }
        // 再描画を実行させる
        invalidate()
        return true
    }
    // クリア処理
    fun clearCanvas(){
        for(i in pathList){
            i.reset()
        }
        invalidate()
    }
}