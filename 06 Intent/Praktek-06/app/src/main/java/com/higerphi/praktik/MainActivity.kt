package com.higerphi.praktek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_part.layoutManager = LinearLayoutManager(this)
        rv_part.setHasFixedSize(true)
        rv_part.adapter =
            ContactAdapter(
                testData,
                { phoneItem: com.higerphi.praktek.PhoneData -> phoneItemClicked(phoneItem) })
    }
    private fun phoneItemClicked(phoneItem: com.higerphi.praktek.PhoneData) {
        val showDetailActivityIntent = Intent(this, com.higerphi.praktek.PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra("NM",  phoneItem.contactName)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData(): List<com.higerphi.praktek.PhoneData> {
        val partList = ArrayList<com.higerphi.praktek.PhoneData>()
        partList.add(
            com.higerphi.praktek.PhoneData(
                9864932,
                "Alpha"
            )
        )
        partList.add(
            com.higerphi.praktek.PhoneData(
                1341933,
                "Bravo"
            )
        )
        partList.add(
            com.higerphi.praktek.PhoneData(
                1401624,
                "Charlie"
            )
        )
        return partList
    }

}