package com.example.conceptsexample.practice

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class FirstExampleView(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {
        val childCount = childCount
        var prevChildRight = 0
        val prevChildBottom = 0
        for (i in 0 until childCount){
            val child: View = getChildAt(i)
            child.layout(prevChildRight, prevChildBottom, prevChildRight+child.measuredWidth, prevChildBottom+child.measuredHeight)
            prevChildRight += child.measuredWidth
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        val childCount = childCount
//        for(i in 0 until childCount){
//            val child: View = getChildAt(i)
//            measureChild(child, widthMeasureSpec, heightMeasureSpec)
//        }

        var totalWidth = 0
        var totalHeight = 0
        val childCount = childCount

        for(i in 0 until childCount){
            val child: View = getChildAt(i)
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            totalWidth += child.measuredWidth
            if(child.measuredHeight > totalHeight){
                totalHeight = child.measuredHeight
            }
        }
        setMeasuredDimension(totalWidth, totalHeight)

    }


}