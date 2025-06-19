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
    companion object {
        val songList = ArrayList<Song>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // created variables
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnGo = findViewById<Button>(R.id.btnGo)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val txtTitle = findViewById<EditText>(R.id.txtTitle)
        val txtArtist = findViewById<EditText>(R.id.txtArtist)
        val txtRating = findViewById<EditText>(R.id.txtRating)
        val txtComment = findViewById<EditText>(R.id.txtComment)

        // add button to add data
        btnAdd.setOnClickListener {
            val title = txtTitle.text.toString()
            val artist = txtArtist.text.toString()
            val rating = txtRating.text.toString().toFloatOrNull()
            val comment = txtComment.text.toString()

            if (title.isEmpty() || artist.isEmpty() || rating == null || comment.isEmpty()) {
                Toast.makeText(this,
                    "Please enter valid song details: ",
                    Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val song = Song(title, artist, rating, comment)
            songList.add(song)
            Toast.makeText(this, "Song Added!", Toast.LENGTH_SHORT).show()

            txtTitle.text.clear()
            txtArtist.text.clear()
            txtRating.text.clear()
            txtComment.text.clear()
        }

        // button navigate to the next screen
        btnGo.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }

        // exit button to exit the app
        btnExit.setOnClickListener {
            finish()
        }
    }
}