package com.example.projet_collectif_mobile.utils

import android.content.Context
import java.io.BufferedReader
import java.io.InputStreamReader

// function qui lit le fichier json et retourne son contenu
fun ReadJSONFromAssets(context: Context, path: String): String {

    try {
        // Ouvre le fichier json (avec contexte il donne acces a assets, avec path on precise le fichier)
        val file = context.assets.open("$path")

        val bufferedReader = BufferedReader(InputStreamReader(file))// Lit le fichier ligne par ligne
        val stringBuilder = StringBuilder() // variable qui stocke le contenu du fichier en une seule chaine de caracteres
        //extension de BufferReader() qui permet d'iterer sur chaque ligne du fichier.
        bufferedReader.useLines { lines ->
            lines.forEach {
                stringBuilder.append(it)
            }
        }
        //convertit le stringBuilder en String immuable
        val jsonString = stringBuilder.toString()

        return jsonString

    } catch (e: Exception) {//si erreur

        e.printStackTrace()
        return ""
    }
}