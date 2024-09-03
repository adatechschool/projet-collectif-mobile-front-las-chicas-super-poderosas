package com.example.projet_collectif_mobile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Se place a id list_view
        val listView=findViewById<ListView>(R.id.list_view)

        // Initie une class Spot crée un tableau dont les éléments reprennent la structure de la classe Spot
        data class Spot(val name: String, val location: String, val picture: String)

        val spots = arrayOf(
            Spot("Teahupoo", "Tahiti", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ02SzYR4LxRVqLo3HFLefhNcE22JjEj24kkw&s"),
            Spot("Biarritz", "France", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-cftY1qwLdelg3ru0m_dllTyCcGWFY2p4TQ&s"),
            Spot("Bondi Beach", "Australia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMViIpETrKU-cQURaTVSng572oH3_z7zf0QQ&s"),
            Spot("Maui", "Hawaii", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMViIpETrKU-cQURaTVSng572oH3_z7zf0QQ&s")
        )

        //initialise Adapter = class native Android
        val arrayAdapter: ArrayAdapter<Spot> = object : ArrayAdapter<Spot>(
            this, R.layout.list_item, spots
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
                spotNameTextView.text = spot?.name
                spotLocationTextView.text = spot?.location

                // Utilisation de Picasso pour charger l'image depuis l'URL - importer picasso
                //Picasso.get().load(spot?.picture).into(spotPictureView)

                return view
            }
        }

        listView.adapter = arrayAdapter










        /* **ETAPE 1**
        //Se place au niveau de l'id
        val listView=findViewById<ListView>(R.id.list_view)

        //Cree un tableau de spots
        val spots = arrayOf("Teahupoo","Biarritz","Bondi Beach","Australia")

        //initialise Adapter = class native Android
        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(
        this, android.R.layout.simple_list_item_1,spots
        )

        //associe adapter à ListView
        listView.adapter=arrayAdapter



        **ETAPE 2**

        //Se place au niveau de l'id
        val listView=findViewById<ListView>(R.id.list_view)

        //Cree une class spot
        data class Spot(val name: String, val location: String)
        val spots = arrayOf(
            Spot("Teahupoo", "Tahiti"),
            Spot("Biarritz", "France"),
            Spot("Bondi Beach", "Australia"),
            Spot("Maui", "Hawaii")
        )

        //initialise Adapter = class native Android
        val arrayAdapter: ArrayAdapter<Spot> = object : ArrayAdapter<Spot>(
            this, android.R.layout.simple_list_item_1, spots
        ) {
            // getView = méthode réitérer vue affichée ds ListView
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent) // super appelle méthode de la classe mère ds laquelle on veut changer des arguments (ici getView)
                val textView = view.findViewById<TextView>(android.R.id.text1)
                textView.text = getItem(position)?.location
                return view
            }
        }

        //associe adapter à ListView
        listView.adapter = arrayAdapter

        */
    }
}