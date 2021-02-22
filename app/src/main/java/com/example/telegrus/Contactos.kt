package com.example.telegrus

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI

/**
 * Contactos
 *
 * @constructor Create empty Contactos
 */
class Contactos : AppCompatActivity(),  View.OnClickListener{
    /**
     * On create
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        /**
         * Asignamos y preparamos los botones para escuchar el evento onClick
         */
        val btn_chat = findViewById<Button>(R.id.btnChat)
        val btn_salir = findViewById<Button>(R.id.btnSalir)
        val btn_contacto = findViewById<Button>(R.id.btnContactTransparent)

        btn_chat.setOnClickListener(this)
        btn_contacto.setOnClickListener(this)
        btn_salir.setOnClickListener(this)

    }

    /**
     * On click
     *
     * @param v
     */
    override fun onClick(v : View?)
    {
        when (v?.id) {
            /**
             * Abrimos una nueva actividad y cerramos otra.
             */
            R.id.btnChat -> {
                val intent = Intent(this,chats::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            /**
             * Abrimos una nueva actividad y cerramos otra.
             */
            R.id.btnSalir -> {
                AuthUI.getInstance().signOut(this).addOnSuccessListener {
                    startActivity(Intent(this,MainActivity::class.java))
                    Toast.makeText(this,"Hasta pronto", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
            /**
             * Abrimos una nueva actividad y cerramos otra.
             */
            R.id.btnContactTransparent -> {
                val intent = Intent(this,chat::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }

}