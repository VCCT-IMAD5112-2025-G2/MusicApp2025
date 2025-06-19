package za.co.varsitycollege.st10468354.musicapp2025

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val titles = arrayOf("Midnight", "Die With A Smile", "Birds Of A Feather", "Perfect")
    private val artists = arrayOf("Taylor Swift", "Bruno Mars", "Billie Eilish", "Ed Sheeran")
    private val ratings = intArrayOf(3, 5, 4, 5)
    private val comments = arrayOf("Love", "Memories", "Calm", "Deep Love")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // created variables
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnGo = findViewById<Button>(R.id.btnGo)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // add button to add data
        btnAdd.setOnClickListener {
            addSongs()
        }

        // button navigate to the next screen
        btnGo.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
            intent.putExtra("songTitles", titles)
            intent.putExtra("artistNames", artists)
            intent.putExtra("songRatings", ratings)
            intent.putExtra("commentSongs", comments)
        }

        // exit button to exit the app
        btnExit.setOnClickListener {
            finish()
        }
    }

    // functions to add songs
    private fun addSongs() {
        Toast.makeText(this, "Please enter valid song titles: ", Toast.LENGTH_LONG).show()
    }
}