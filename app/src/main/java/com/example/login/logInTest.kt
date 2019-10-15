package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class logInTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in_test)

        supportActionBar?.hide()

        val etPass = findViewById<EditText>(R.id.etPass)
        val etmail = findViewById<EditText>(R.id.etEmail)
        val btnLogin = findViewById<Button>(R.id.btnLoginSubmit)

        btnLogin.setOnClickListener(View.OnClickListener {
            var passVar:String = etPass.text.toString()
            var emailVar:String = etmail.text.toString()
            if (true){
                Toast.makeText(this,"pass: $passVar , user: $emailVar", Toast.LENGTH_LONG).show()
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Password incorrecto", Toast.LENGTH_LONG).show()
            }
        } )


    }
}
