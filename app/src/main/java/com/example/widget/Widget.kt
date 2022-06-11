package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

//Membuat Variabel binding
private lateinit var binding : ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        //memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        //button toast
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Ini Adalah Toast",Toast.LENGTH_SHORT).show()
        }
        //Button Snackbar
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "Ini Adalah Snackbar",Snackbar.LENGTH_SHORT).show()
        }
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("Ini Adalah Alert")

                setPositiveButton("OK"){dialog, _ ->
                    Toast.makeText(applicationContext, "Anda Klik OK",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }
                setNegativeButton("BACK"){dialog, _ ->
                    Toast.makeText(applicationContext, "Anda Klik BACK",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }
            }.show()
        }
        //Button Custome Dialog
        binding.btnCustomDialog.setOnClickListener{
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custome_dialog)

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener{
                    Toast.makeText(applicationContext,"Anda Klik Cancel", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
                btnContinue.setOnClickListener{
                    Toast.makeText(applicationContext,"Anda Klik Continue", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

            }.show()
        }



    }
}