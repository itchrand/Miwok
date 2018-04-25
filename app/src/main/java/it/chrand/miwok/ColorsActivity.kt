package it.chrand.miwok

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class ColorsActivity : AppCompatActivity() {

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
        words.add(Word("weṭeṭṭi","red", R.raw.color_red, R.drawable.color_red))
        words.add(Word("chokokki","green", R.raw.color_green, R.drawable.color_green))
        words.add(Word("ṭakaakki","brown", R.raw.color_brown, R.drawable.color_brown))
        words.add(Word("ṭopoppi","gray", R.raw.color_gray, R.drawable.color_gray))
        words.add(Word("kululli","black", R.raw.color_black, R.drawable.color_black))
        words.add(Word("kelelli","white", R.raw.color_white, R.drawable.color_white))
        words.add(Word("ṭopiisә","dusty yellow", R.raw.color_dusty_yellow, R.drawable.color_dusty_yellow))
        words.add(Word("chiwiiṭә","mustard yellow", R.raw.color_mustard_yellow, R.drawable.color_mustard_yellow))

        val itemsAdapter = WordAdapter(this, words, R.color.category_colors)

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
