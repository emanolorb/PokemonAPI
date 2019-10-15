package com.example.login

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener(View.OnClickListener {
            if (Network.checkRed(this)){
                Toast.makeText(this, "Hay red", Toast.LENGTH_SHORT).show()
                getPoke("1")
            } else {
                Toast.makeText(this, "No hay conexion a internet", Toast.LENGTH_SHORT).show()
            }

        })



    }

//    get method volly
    private fun getPoke(url:String){
    val textView = findViewById<TextView>(R.id.textView2)
// ...

// Instantiate the RequestQueue.
    val queue = Volley.newRequestQueue(this)
    val urlFinal = "https://pokeapi.co/api/v2/pokemon/$url/"

// Request a string response from the provided URL.
    val stringRequest = StringRequest(Request.Method.GET, urlFinal,
        Response.Listener<String> { response ->
            // Display the first 500 characters of the response string.
            try {
                textView.text = "Response is: ${response.substring(0, 500)}"
            }catch (e: Exception){
                Log.d("request", e.toString())
            }

        },
        Response.ErrorListener { textView.text = "That didn't work!" })

// Add the request to the RequestQueue.
    queue.add(stringRequest)

    }
}
