package za.co.varsitycollege.st10468354.musicapp2025

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class DetailedViewScreen : AppCompatActivity() {
    private val titles = arrayOf("Midnight", "Die With A Smile", "Birds Of A Feather", "Perfect")
    private val artists = arrayOf("Taylor Swift", "Bruno Mars", "Billie Eilish", "Ed Sheeran")
    private val ratings = intArrayOf(3, 5, 4, 5)
    private val comments = arrayOf("Love", "Memories", "Calm", "Deep Love")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        // created variables
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnRating = findViewById<Button>(R.id.btnRating)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        // display button to display user inputs
        btnDisplay.setOnClickListener {

        }

        // rating button to see ratings of the songs
        btnRating.setOnClickListener {

        }

        // return to the main screen
        btnReturn.setOnClickListener {
            finish()
        }
    }
}