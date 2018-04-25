package it.chrand.miwok

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {

    private var mediaPlayer : MediaPlayer? = null
    private val mCompletionListener: MediaPlayer.OnCompletionListener = MediaPlayer.OnCompletionListener {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)

        // Create an array of words
        val words = ArrayList<Word>()
        words.add(Word("әpә","father", R.raw.family_father, R.drawable.family_father))
        words.add(Word("әṭa","mother", R.raw.family_mother, R.drawable.family_mother))
        words.add(Word("angsi","son", R.raw.family_son, R.drawable.family_son))
        words.add(Word("tune","daughter", R.raw.family_daughter, R.drawable.family_daughter))
        words.add(Word("taachi","older brother", R.raw.family_older_brother, R.drawable.family_older_brother))
        words.add(Word("chalitti","younger brother", R.raw.family_younger_brother, R.drawable.family_younger_brother))
        words.add(Word("teṭe","older sister", R.raw.family_older_sister, R.drawable.family_older_sister))
        words.add(Word("kolliti","younger sister", R.raw.family_younger_sister, R.drawable.family_younger_sister))
        words.add(Word("ama","grandmother", R.raw.family_grandmother, R.drawable.family_grandmother))
        words.add(Word("paapa","grandfather", R.raw.family_grandfather, R.drawable.family_grandfather))

        val itemsAdapter = WordAdapter(this, words, R.color.category_family)

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
