package vcmsa.ci.mymusicplaylistmanager


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import android.widget.Toast

class MainActivity : ComponentActivity() {
    private val songTiles = arrayOfNulls<R.string>(4)
    private val artistNames = arrayOfNulls<R.string>(4)
    private val songRatings = IntArray(4)
    private val songComment = arrayOfNulls<R.string>(4)
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add screen buttons
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)
        val btnExit = findViewById<Button>(R.id.btnExit)

        //Set click listeners
        btnAdd.setOnClickListener { addToPlaylist() }
        btnView.setOnClickListener { navigateToDetailedView() }
        btnExit.setOnClickListener { finish() }
    }

    private fun addToPlaylist() {
        if (currentIndex >= 4) {
            Toast.makeText(this, "Playlist is full", Toast.LENGTH_SHORT).show()
            return
        }
        val titleEditText = findViewById<EditText>(R.id.titleEditText)
        val artistEditText = findViewById<EditText>(R.id.artistEditText)
        val ratingEditText = findViewById<EditText>(R.id.ratingEditText)
        val commentEditText = findViewById<EditText>(R.id.commentEditText)

        try {
            val title = titleEditText.text.toString()
            val artist = artistEditText.text.toString()
            val rating = ratingEditText.text.toString().toInt()
            val comment = commentEditText.text.toString()

            if (rating < 1 || rating > 5) {
                Toast.makeText(this, "Rating must be between 1 and 5", Toast.LENGTH_SHORT).show()
                return
            }

            //clear fields
            titleEditText.text.clear()
            artistEditText.text.clear()
            ratingEditText.text.clear()
            commentEditText.text.clear()

            Toast.makeText(this, "Song added to Playlist!", Toast.LENGTH_SHORT).show()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Please enter a valid rating (1-5)", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToDetailedView() {
        if (currentIndex == 0) {
            Toast.makeText(this, "Please add at least one song first", Toast.LENGTH_SHORT).show()
            return
        }
    }
}






