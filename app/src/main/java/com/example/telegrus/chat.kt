package com.example.telegrus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton


/**
 * Chat
 * @author Andrei, Oscar
 * @constructor Create empty Chat
 */
class chat : AppCompatActivity(), View.OnClickListener{
    /**
     * On create
     *
     * @param savedInstanceState
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        /**
         * Escondemos la appbar predeterminada del proyecto
         */
         supportActionBar?.hide();

        /**
         * Asignamos y preparamos los botones para escuchar el evento onClick
         */
        val btn_volver = findViewById<ImageButton>(R.id.btnVolver)
        btn_volver.setOnClickListener(this)



    }

    /**
     * On click
     *
     * @param v Pasamos parametro del View
     */
    override fun onClick(v : View?)
    {
        when (v?.id) {
            /**
             * Abrimos una nueva actividad y cerramos otra.
             */
            R.id.btnVolver -> {
                val intent = Intent(this,chats::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }
}