package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Récupération des widgets existants
        val premierBouton: Button = findViewById(R.id.premierButton)
        val saisie: EditText = findViewById(R.id.saisieText)
        val layoutPrincipal: ConstraintLayout = findViewById(R.id.main)

        // 🔹 Clic sur le bouton
        premierBouton.setOnClickListener {

            val texteSaisi = saisie.text.toString()

            if (texteSaisi == "afficher nouveau textView") {

                // Création du nouveau TextView
                val deuxiemeTextView = TextView(this)

                // Affectation du texte
                deuxiemeTextView.text = texteSaisi
                deuxiemeTextView.textSize = 18f

                // Ajout au layout principal
                layoutPrincipal.addView(deuxiemeTextView)
            }
        }
    }
}
