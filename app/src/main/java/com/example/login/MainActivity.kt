package com.example.login

import PokemonObjectClass
import Types
import android.app.Activity
import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener(View.OnClickListener {
            if (Network.checkRed(this)){
                val etSearch = findViewById<EditText>(R.id.etPokemon)
                var searchPokemon:String = etSearch.text.toString()
                if (searchPokemon.isNotEmpty()){
                    getPoke(searchPokemon)
                }else {
                    Toast.makeText(this, "Inserta un pokemon a Buscar", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "No hay conexion a internet", Toast.LENGTH_SHORT).show()
            }

        })



    }

//    get method volly
    private fun getPoke(url:String){

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvNumber = findViewById<TextView>(R.id.tvNumber)
        val tvType = findViewById<TextView>(R.id.etType)
        // ...

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val urlFinal = "https://pokeapi.co/api/v2/pokemon/$url/"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(Request.Method.GET, urlFinal,
            Response.Listener<String> { response ->


                 //  Print info in Activity
                val pokeInfo = Gson().fromJson(response.toString(), PokemonObjectClass::class.java)
                try {
                    var typesString:String = ""
                    for (i in 0..pokeInfo.types.size-1){
                        var rowTipe:Types = pokeInfo.types.get(i)
                        Log.d("test", rowTipe.type.name)
                        if (i == 0){
                            typesString = "${rowTipe.type.name}"
                        }else{
                            typesString = "$typesString-${rowTipe.type.name}"
                        }

                    }
//                    ivPokeMale
                    Picasso.get().load(pokeInfo.sprites.front_default).into(ivPokeMale)
                    Picasso.get().load(pokeInfo.sprites.front_female).into(ivPokeFemale)
                    Picasso.get().load(pokeInfo.sprites.front_shiny).into(ivPokeMaleShiny)
                    Picasso.get().load(pokeInfo.sprites.front_shiny_female).into(ivPokeFemaleShiny)
                    tvName.text = "Nombre: ${pokeInfo.name}"
                    tvNumber.text = "Numero: ${pokeInfo.id}"
                    tvType.text = "Tipo: $typesString"
                }catch (e: Exception){
                    Log.d("request", e.toString())
                }

            },
            Response.ErrorListener {
                tvName.text = "No se encontro ese pokemon"
                tvNumber.text = ""
                tvType.text = ""
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)

    }
}
