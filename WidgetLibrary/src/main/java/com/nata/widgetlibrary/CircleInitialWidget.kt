package com.nata.widgetlibrary

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.widget_circle_initial.view.*
import java.lang.Exception
import java.util.*

class CircleInitialWidget(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleInitialWidget)
        val size = typedArray.getInteger(R.styleable.CircleInitialWidget_size, 0)
        typedArray.recycle()

        LayoutInflater.from(context).inflate(R.layout.widget_circle_initial, this)

        this.tv_initial.setTextSize(TypedValue.COMPLEX_UNIT_SP, if (size == 1) 24f else 12f)
    }

    private fun getShapeBackground(): GradientDrawable? {
        return try {
            this.iv_profile.background.mutate() as GradientDrawable
        } catch (e:Exception) {
            null
        }
    }

    fun setBackgroundColor(colorCode: String, colorCodeEnd: String? = null) {
        val bg = getShapeBackground()
        if (bg != null) {
            bg.colors = intArrayOf(Color.parseColor(colorCode), Color.parseColor(colorCodeEnd ?: colorCode))
        }
    }

    fun setInitial(text: String?) {
        this.tv_initial.text = text.getInitial()
    }

    private fun String?.getInitial(): String {
        return if (this != null) {
            val splitText = this.split(' ')
            if(splitText.size >= 2) {
                (splitText[0].first().toString() + splitText[1].first().toString()).toUpperCase(Locale.getDefault())
            } else {
                splitText[0].first().toString().toUpperCase(Locale.getDefault())
            }
        } else {
            "?"
        }
    }
}