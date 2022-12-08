package com.higerphi.Tugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener {

    val list = ArrayList<Users>()
    val listUser = arrayOf(
        "Hana Macchia",
        "Taka Radjiman",
        "Mika Melatika",
        "Rai Galilei",
        "Reza Avanluna",
        "Miyu Ottavia",
        "Derem Kado",
        "Bonivier Pranaja",
        "Akuma Vox"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager (this)
        for (i in 0 until listUser.size){
            list.add(Users(listUser.get(i)))
            if (listUser.size - 1 == i){
                val adapter = Adapter (list,this)
                adapter.notifyDataSetChanged()
                mRecyclerView.adapter = adapter
            }
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,
            "anda menyukai twiit "+ listUser .get(position), Toast.LENGTH_LONG).show()

    }
}