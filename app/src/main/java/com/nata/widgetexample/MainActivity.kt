package com.nata.widgetexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ciw_name_big.setInitial("Clarissa Eliani Sutikno")
        ciw_name_big.setBackgroundColor("#ACD4EF")
    }
}