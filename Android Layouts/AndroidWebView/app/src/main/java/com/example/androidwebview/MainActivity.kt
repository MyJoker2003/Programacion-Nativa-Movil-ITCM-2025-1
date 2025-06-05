package com.example.androidwebview

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Encontrar el WebView por su id unica
        val webView = findViewById<WebView>(R.id.web)

        //Cargando https://write.geeksforgeeks.org en el webView
        webView.loadUrl("https://write.geeksforgeeks.org")

        //esta instruccion habilita el uso de JS
        webView.settings.javaScriptEnabled =  true

        webView.webViewClient = WebViewClient()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}