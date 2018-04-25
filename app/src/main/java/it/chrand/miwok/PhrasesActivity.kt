package it.chrand.miwok

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {

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
        words.add(Word("minto wuksus","Where are you going?", R.raw.phrase_where_are_you_going))
        words.add(Word("tinnә oyaase'nә","What is your name?", R.raw.phrase_what_is_your_name))
        words.add(Word("oyaaset...","My name is...", R.raw.phrase_my_name_is))
        words.add(Word("michәksәs?","How are you feeling?", R.raw.phrase_how_are_you_feeling))
        words.add(Word("kuchi achit","I’m feeling good.", R.raw.phrase_im_feeling_good))
        words.add(Word("әәnәs'aa?","Are you coming?", R.raw.phrase_are_you_coming))
        words.add(Word("hәә’ әәnәm","Yes, I’m coming.", R.raw.phrase_yes_im_coming))
        words.add(Word("әәnәm","I’m coming.", R.raw.phrase_im_coming))
        words.add(Word("yoowutis","Let’s go.", R.raw.phrase_lets_go))
        words.add(Word("әnni'nem","Come here.", R.raw.phrase_come_here))

        val itemsAdapter = WordAdapter(this, words, R.color.category_phrases)

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
