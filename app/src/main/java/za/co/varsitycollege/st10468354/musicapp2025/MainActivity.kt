package za.co.varsitycollege.st10468354.musicapp2025

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.mutableIntListOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val songTitles = mutableListOf<String>()
    private val songArtists = mutableListOf<String>()
    private val songRatings = mutableListOf<Int>()
    private val songComments = mutableListOf<String>()

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
            val intent = Intent(this, DetailedViewScreen::class.java).apply {
                putStringArrayListExtra("songs", ArrayList(songTitles))
                putStringArrayListExtra("artists", ArrayList(songArtists))
                putIntegerArrayListExtra("ratings", ArrayList(songRatings))
                putStringArrayListExtra("comments", ArrayList(songComments))
            }
            startActivity(intent)
        }

        // exit button to exit the app
        btnExit.setOnClickListener {
            finish()
        }
    }

    // functions to add songs
    private fun addSongs() {
        // a dialog view to enter data
        val dialogView = layoutInflater.inflate(R.layout.activity_main, null)

        // created variables
        val songTitle = dialogView.findViewById<EditText>(R.id.songTitle)
        val artistName = dialogView.findViewById<EditText>(R.id.artistName)
        val songRating = dialogView.findViewById<EditText>(R.id.songRating)
        val songComment = dialogView.findViewById<EditText>(R.id.songComment)

        // when button clicked, user can enter data
        AlertDialog.Builder(this)
             .setTitle("Add to Playlist")
             .setView(dialogView)
             .setPositiveButton("Add") { _, _ ->
                val title = songTitle.text.toString().trim()
                val artist = artistName.text.toString().trim()
                val ratingStr = songRating.text.toString().trim()
                val comment = songComment.text.toString().trim()

                 val rating = ratingStr.toIntOrNull()

                if (songTitles.isEmpty() || songArtists.isEmpty() || songRatings == null) {
                    Toast.makeText(this,
                        "Please enter valid song details: ",
                        Toast.LENGTH_SHORT)
                        .show()
                    return@setPositiveButton
                }

                songTitles.add(title)
                songArtists.add(artist)
                 if (rating != null) {
                     songRatings.add(rating)
                 }
                songComments.add(comment)

                Log.d("Add to Playlist", "Added: $title ($artist) x$rating - $comment")
             }
            .setNegativeButton("cancel", null)
            .show()
    }
}