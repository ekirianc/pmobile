package com.higerphi.praktek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_phone_detail.*

class PhoneDetailActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_detail)
        var intentThatStartedThisActivity = getIntent()

        var partID = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
        var partNM = intentThatStartedThisActivity.getStringExtra("NM")
        tv_item_id.text = partID
        tv_item_nama.text = partNM
    }
}
