package com.example.uts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val wisata = intent.getParcelableExtra<WisataClass>(MainActivity.INTENT_PARCELABLE)

        val wisataimg = findViewById<ImageView>(R.id.image)
        val wisataname = findViewById<TextView>(R.id.tv_name)
        val wisatalocation = findViewById<TextView>(R.id.tv_location)
        val wisatarate = findViewById<TextView>(R.id.tv_rating)
        val ratingbar = findViewById<RatingBar>(R.id.ratingbar)
        val wisatadesc = findViewById<TextView>(R.id.tv_description)

        val buttonlink = findViewById<Button>(R.id.btn_direct_link)
        buttonlink.setOnClickListener {
            val url = "https://id.m.wikipedia.org/wiki/Daftar_tempat_wisata_di_Kalimantan_Selatan"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        wisataimg.setImageResource(wisata?.wisataimg!!)
        wisataname.text = wisata.wisataname
        wisatalocation.text = wisata.wisatalocation
        wisatarate.text = wisata.wisatarate
        ratingbar.rating = wisata.ratingbar.toFloat()
        wisatadesc.text = wisata.wisatadesc
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
