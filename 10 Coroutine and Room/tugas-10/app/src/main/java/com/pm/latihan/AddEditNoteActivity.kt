package com.pm.latihan

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_note.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TANGGAL = "EXTRA_TANGGAL"
        const val EXTRA_ID = "EXTRA_ID"
        const val EXTRA_JUDUL = "EXTRA_JUDUL"
        const val EXTRA_DESKRIPSI = "EXTRA_DESKRIPSI"
        const val EXTRA_PRIORITAS = "EXTRA_PRIORITAS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_clear_24)

        //EditText text value depend on EXTRA_ID value
        if (intent.hasExtra(EXTRA_ID)) {
            title = "Edit Catatan"
            edit_text_title.setText(intent.getStringExtra(EXTRA_JUDUL))
            deadlineText.setText(intent.getStringExtra(EXTRA_TANGGAL))
            edit_text_description.setText(intent.getStringExtra(EXTRA_DESKRIPSI))
            prioritas.isChecked = intent.getBooleanExtra(EXTRA_PRIORITAS, false)
        } else {
            title = "Tambah Catatan"
        }

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLabel(myCalendar)
        }

        deadlineButton.setOnClickListener{
            DatePickerDialog(this, datePicker,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH),
            ).show()
        }
    }

    private fun updateLabel(myCalendar: Calendar) {
        val myFormat = "dd MMM yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        deadlineText.setText(sdf.format(myCalendar.time))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_note -> {
                saveNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //action when save button pressed
    private fun saveNote() {
        //check EditText
        if (edit_text_title.text.toString().trim().isBlank()) {
            Toast.makeText(this, "Catatan kosong!", Toast.LENGTH_SHORT).show()
            return
        }
        //data value depend on tanggal checkbox check status
        var data =
        if (prioritas.isChecked()){
            Intent().apply {
                putExtra(EXTRA_JUDUL, edit_text_title.text.toString())
                putExtra(EXTRA_TANGGAL, deadlineText.text.toString())
                putExtra(EXTRA_DESKRIPSI, edit_text_description.text.toString())
                putExtra(EXTRA_PRIORITAS, true)
                if (intent.getIntExtra(EXTRA_ID, -1) != -1) {
                    putExtra(EXTRA_ID, intent.getIntExtra(EXTRA_ID, -1))
                }
            }
        }else{
            Intent().apply {
                putExtra(EXTRA_JUDUL, edit_text_title.text.toString())
                putExtra(EXTRA_TANGGAL, deadlineText.text.toString())
                putExtra(EXTRA_DESKRIPSI, edit_text_description.text.toString())
                putExtra(EXTRA_PRIORITAS, false)
                if (intent.getIntExtra(EXTRA_ID, -1) != -1) {
                    putExtra(EXTRA_ID, intent.getIntExtra(EXTRA_ID, -1))
                }
            }
        }

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}