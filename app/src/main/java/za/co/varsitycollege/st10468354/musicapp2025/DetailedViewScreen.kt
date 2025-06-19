package za.co.varsitycollege.st10468354.musicapp2025

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.mutableIntListOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class DetailedViewScreen : AppCompatActivity() {
    private lateinit var txeSongs: TextView
    private lateinit var txeAverage: TextView
    private lateinit var btnDisplay: Button
    private lateinit var btnAverage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        // created variables
        val txeSongs = findViewById<TextView>(R.id.txeSongs)
        val txeAverage = findViewById<TextView>(R.id.txeAverage)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnRating = findViewById<Button>(R.id.btnRating)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        // display button to display user inputs
        btnDisplay.setOnClickListener {
            val builder = StringBuilder()
            for ((index, song) in MainActivity.songList.withIndex()) {
                builder.append("Song ${index + 1}:\n")
                builder.append("Title: ${song.title}\n")
                builder.append("Artist: ${song.artist}\n")
                builder.append("Rating: ${song.rating}\n")
                builder.append("Comment: ${song.comment}\n")
            }
            txeSongs.text = builder.toString()
        }

        // rating button to see ratings of the songs
        btnRating.setOnClickListener {
            var total = 0f
            for (song in MainActivity.songList) {
                total += song.rating
            }
            val avg = if (MainActivity.songList.isNotEmpty()) total / MainActivity.songList.size else 0f
            txeAverage.text = "Average Rating: %.2f".format(avg)
        }

        // return to the main screen
        btnReturn.setOnClickListener {
            finish()
        }
    }
}
