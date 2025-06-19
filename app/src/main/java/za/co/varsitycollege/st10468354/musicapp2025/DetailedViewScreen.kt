package za.co.varsitycollege.st10468354.musicapp2025

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.mutableIntListOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class DetailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        // created variables
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnRating = findViewById<Button>(R.id.btnRating)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        val titles = intent.getStringArrayListExtra("titles") ?: arrayListOf()
        val artists = intent.getStringArrayListExtra("artists") ?: arrayListOf()
        val ratings = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        val comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()

        val minRating = intArrayOf()
        val maxRating = intArrayOf()


        // display button to display user inputs
        btnDisplay.setOnClickListener {
            val displayList = arrayOf<String>()
            for (i in titles.indices) {
                if (ratings[i] >= 5) {
                    //displayList.add("${titles[i]} (${artists[i]}) x${ratings[i]}: ${comments[i]}")
                }
            }
            if (displayList.isEmpty()) {
                btnDisplay.text = "No items with quantity >= 5"
            } else {
                btnDisplay.text = displayList.joinToString("\n\n\n\n")
            }
        }

        // rating button to see ratings of the songs
        btnRating.setOnClickListener {
            val averageRating = getAverageRating(minRating, maxRating)
            btnRating.text = "Rating songs: ${averageRating}"
        }

        // return to the main screen
        btnReturn.setOnClickListener {
            finish()
        }
    }

    // calculation for the ratings
    private fun getAverageRating(minRating: IntArray, maxRating: IntArray): Double {
        var totalMinRating = 0
        var totalMaxRating = 0

        for (i in minRating.indices) {
            totalMinRating += minRating[i]
            totalMaxRating += maxRating[i]
        }
        val averageMin = totalMinRating / minRating.size
        val averageMax = totalMaxRating / maxRating.size
        return (averageMin + averageMax) /2.0
    }
}
