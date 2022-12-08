package com.higerphi.praktik

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
            ContactAdapter(testData, { phoneItem: PhoneData -> phoneItemClicked(phoneItem) })
    }
    private fun phoneItemClicked(phoneItem: PhoneData) {
        val showDetailActivityIntent = Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.harga.toString())
        showDetailActivityIntent.putExtra("NM",  phoneItem.modelLaptop)
        showDetailActivityIntent.putExtra("AL",  phoneItem.spek)
        startActivity(showDetailActivityIntent)
    }
    private fun createPhoneData(): List<PhoneData> {
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(
            "Rp 3,5 jutaan",
            "Axioo My Book 11 Lite",
            "Layar: 11 inch HD\n" +
                    "Processor: Intel Z8350 Quad Core up to 1.92GHz\n" +
                    "RAM: 4GB\n" +
                    "Storage: 128GB (eMMC 64GB + 64GB Micro SD)\n" +
                    "Battery: 8000 mAh\n" +
                    "Sistem Operasi: DOS"))
        partList.add(PhoneData(
            "Rp 3,8 jutaan",
            "Zyrex Notebook Sky 232A",
            "Layar: IPS LCD 14 inci resolusi Full HD 1920 x 10080 piksel\n" +
                    "Prosesor: AMD APU A4-9125 dual-core 2,3GHz, Turbo Core 2,6GHz\n" +
                    "RAM: 4GB DDR4 2133MHz, single-channel, onboard\n" +
                    "Storage: SSD SATA III 128GB, tersedia slot M.2 2280\n" +
                    "Baterai: 37Wh, 5000mAh dengan daya tahan 6 – 10 jam\n" +
                    "Sistem Operasi: Microsoft Windows 10 Home x64 OEM"))
        partList.add(PhoneData(
            "Rp 5,5 jutaan",
            "Lenovo IdeaPad 330 14AST",
            "Layar: IPS LCD 14 inci FHD 1920 x 1080\n" +
                    "Prosesor: AMD A9-9425\n" +
                    "RAM: 4GB (1X4GBDDR4 2133)\n" +
                    "Storage: 1TB HDD\n" +
                    "Baterai: 2CELL 30WH\n" +
                    "Sistem Operasi: Windows 10 Home"))
        partList.add(PhoneData(
            "Rp 6,9 jutaan",
            "HP 14s CF1051TU",
            "Layar: 14 inch HD SVA BrightView micro-edge, resolusi 1366 x 768\n" +
                    "Prosesor: Intel Celeron 4205U (1.8 GHz, 2 MB cache, 2 cores)\n" +
                    "RAM: 4 GB DDR4-2133 SDRAM (1 x 4 GB)\n" +
                    "Storage: 512 GB SSD PCIe NVMe M.2 SSD\n" +
                    "Baterai: 3-cell, 41 Wh Li-ion, 45 W Smart AC power adapter\n" +
                    "Sistem Operasi: Windows 10 Home"))
        return partList
    }

}