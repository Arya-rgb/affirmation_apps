package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.ScrollView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ItemAdapter
import com.example.myapplication.data.Datasource
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerFrameLayout
import java.util.logging.Handler
import javax.sql.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadAffirmation()


        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        android.os.Handler(Looper.getMainLooper()).postDelayed({
            recyclerView.adapter = ItemAdapter(this, myDataset)
            findViewById<ShimmerFrameLayout>(R.id.progress_bar).visibility = View.GONE
        },3000)

        recyclerView.setHasFixedSize(true)

    }
}