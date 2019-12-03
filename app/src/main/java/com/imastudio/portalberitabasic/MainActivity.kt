package com.imastudio.portalberitabasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.imastudio.kotlinketigaapp.network.InitRetrofit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitRetrofit.getInstance()
    }
}
