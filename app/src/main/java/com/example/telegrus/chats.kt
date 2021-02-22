package com.example.telegrus

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth





/**
 * Chats
 * @author Andrei, Oscar
 * @constructor Create empty Chats
 */
class chats : AppCompatActivity(),  View.OnClickListener {



    /**
     * On create
     *
     * @param savedInstanceState Pasamos parametro necesario.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)


        /**
         * Asignamos y preparamos los botones para escuchar el evento onClick
         */

        val btn_Contacts = findViewById<Button>(R.id.btnContacts)
        val btn_salir = findViewById<Button>(R.id.btnSalir)
        val btn_chat = findViewById<Button>(R.id.btnContactTransparent2)

        btn_chat.setOnClickListener(this)
        btn_Contacts.setOnClickListener(this)
        btn_salir.setOnClickListener(this)





    }

    /**
     * On click
     * @param v Pasamos parametro del View
     */
    override fun onClick(v: View?)
    {
        when (v?.id) {
            /**
             * Abrimos una nueva actividad y cerramos otra.
             */
            R.id.btnSalir -> {

                AuthUI.getInstance().signOut(this).addOnSuccessListener {
                    startActivity(Intent(this,MainActivity::class.java))
                    Toast.makeText(this,"Hasta pronto",Toast.LENGTH_SHORT).show()
                    finish()
                }

            }
            /**
             * Abrimos una nueva actividad y cerramos otra.
             */
            R.id.btnContacts -> {
                val intent = Intent(this, Contactos::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
            /**
             * Abrimos una nueva actividad y cerramos otra.
             */
            R.id.btnContactTransparent2 -> {
                val intent = Intent(this, chat::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }
    }



}