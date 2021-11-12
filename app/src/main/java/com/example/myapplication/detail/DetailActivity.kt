package com.example.myapplication.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        loadData()

    }

    private fun loadData() {
        findViewById<ImageView>(R.id.tv_imageview).setImageResource(intent.getIntExtra(EXTRA_PHOTO,0))
        findViewById<TextView>(R.id.tv_detail).text = intent.getStringExtra(EXTRA_WORD).toString()
    }

    companion object {
        const val EXTRA_WORD = "extra_word"
        const val EXTRA_PHOTO = "extra_photo"
    }

}