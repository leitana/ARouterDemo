package com.lx.app2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        tv1.setOnClickListener {
            val uri = Uri.parse("arouter://m.asiainfo.com/main_app/normal1_activity")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        tv2.apply {
            text = "arouter://m.asiainfo.com/main_app/normal4_activity?name=alex&age=18&boy=true&high=180&obj=%7b%22name%22%3a%22jack%22%2c%22id%22%3a666%7d"
            setOnClickListener {
                val uri = Uri.parse(text as String)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
        tv3.apply {
            text = "http://m.asiainfo.com/main_app/normal1_activity"
            setOnClickListener {
                val uri = Uri.parse(text as String)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }

        tv4.apply {
            text = "https://m.asiainfo.com/main_app/normal1_activity"
            setOnClickListener {
                val uri = Uri.parse(text as String)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }

        tv5.apply {
            text = "https://m.asiainfo.com/xx/xx"
            setOnClickListener {
                val uri = Uri.parse(text as String)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
    }
}
