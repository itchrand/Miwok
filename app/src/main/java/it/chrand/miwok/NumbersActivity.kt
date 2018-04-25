package it.chrand.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener


class NumbersActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private val mCompletionListener: MediaPlayer.OnCompletionListener = MediaPlayer.OnCompletionListener {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)

        // Create an array of words
        val words = ArrayList<Word>()
        words.add(Word("lutti", "one", R.raw.number_one, R.drawable.number_one))
        words.add(Word("otiiko", "two", R.raw.number_two, R.drawable.number_two))
        words.add(Word("tolookosu", "three", R.raw.number_three, R.drawable.number_three))
        words.add(Word("oyyisa", "four", R.raw.number_four, R.drawable.number_four))
        words.add(Word("massokka", "five", R.raw.number_five, R.drawable.number_five))
        words.add(Word("temmokka", "six", R.raw.number_six, R.drawable.number_six))
        words.add(Word("kenekaku", "seven", R.raw.number_seven, R.drawable.number_seven))
        words.add(Word("kawinta", "eight", R.raw.number_eight, R.drawable.number_eight))
        words.add(Word("wo’e", "nine", R.raw.number_nine, R.drawable.number_nine))
        words.add(Word("na’aacha", "ten", R.raw.number_ten, R.drawable.number_ten))

        val itemsAdapter = WordAdapter(this, words, R.color.category_numbers)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            releaseMediaPlayer()
            mediaPlayer = MediaPlayer.create(this, words[position].audioRessourdeId)
            mediaPlayer?.start()
            mediaPlayer?.setOnCompletionListener(mCompletionListener)
        }
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private fun releaseMediaPlayer() {
        mediaPlayer?.release()  // kotlin safe-call operator
        mediaPlayer = null
    }
}
