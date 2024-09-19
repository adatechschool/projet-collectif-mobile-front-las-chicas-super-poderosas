package com.example.projet_collectif_mobile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.projet_collectif_mobile.models.SurfSpot
import com.example.projet_collectif_mobile.ui.screens.SpotsViewModel
import com.example.projet_collectif_mobile.R
import com.example.projet_collectif_mobile.SpotActivity




import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projet_collectif_mobile.models.ClassJson
import com.example.projet_collectif_mobile.utils.ReadJSONFromAssets
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    // Utiliser la méthode viewModels pour instancier le ViewModel
    private val spotsViewModel: SpotsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Récupère les données du fichier JSON
        //val jsonString = ReadJSONFromAssets(baseContext, path = "spotsData.json")
        // Convertit le JSON en objet Kotlin
        //val data = Gson().fromJson(jsonString, ClassJson::class.java)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Se place a id list_view
        val listView=findViewById<ListView>(R.id.list_view)


        //initialise Adapter = class native Android
        // val arrayAdapter: ArrayAdapter<ClassJson.SurfSpot> = object : ArrayAdapter<ClassJson.SurfSpot>(
        //    this, R.layout.list_item, data.records
        //  ) {

        // Observer les changements de spotsUiState dans le ViewModel
        spotsViewModel.spotsUiState.observe(this, Observer { spotsList ->
            // spotsList contient la liste des spots, à utiliser dans l'ArrayAdapter

            //initialise Adapter = class native Android
            val arrayAdapter: ArrayAdapter<SurfSpot> = object : ArrayAdapter<SurfSpot>(
                this, R.layout.list_item, spotsList
            ) {
                // surcharge méthode getView
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    // Réutiliser les vues converties ou en créer de nouvelles si nécessaire
                    val inflater = LayoutInflater.from(context)
                    val view = convertView ?: inflater.inflate(R.layout.list_item, parent, false)


                    // Récupérer l'objet Spot pour la position actuelle
                    val spot = getItem(position)

                    // Récupérer les TextViews pour afficher le nom et l'emplacement
                    val spotNameTextView = view.findViewById<TextView>(R.id.spot_name)
                    val spotLocationTextView = view.findViewById<TextView>(R.id.spot_location)
                    val spotPictureView = view.findViewById<ImageView>(R.id.spot_img)

                    // Remplir les TextViews avec les données de l'objet Spot
                    spotNameTextView.text = spot?.surfBreak?.joinToString(", ")
                    spotLocationTextView.text = spot?.address

                    // Utilisation de Picasso pour charger l'image depuis l'URL - importer picasso
                    //Picasso.get().load(spot?.picture).into(spotPictureView)

                    val button = view.findViewById<Button>(R.id.spot_btn)
                    button.setOnClickListener {
                        // Créer un Intent pour lancer SpotDetailActivity
                        val intent = Intent(applicationContext, SpotActivity::class.java)

                        // Ajouter les détails du Spot à l'Intent
                        intent.putExtra("SPOT_NAME", spot?.surfBreak?.joinToString(", "))
                        intent.putExtra("SPOT_LOCATION", spot?.address)

                        // Lancer l'activité
                        startActivity(intent)
                    }

                    return view
                }
            }

            listView.adapter = arrayAdapter

        })
        spotsViewModel.getSpotsList()
    }}