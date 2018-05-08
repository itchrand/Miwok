package it.chrand.miwok

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {

    private var mediaPlayer : MediaPlayer? = null
    private val mCompletionListener: MediaPlayer.OnCompletionListener = MediaPlayer.OnCompletionListener {
        // Now that the sound file has finished playing, release the media player resources.
        releaseMediaPlayer()
    }

    private var audioManager: AudioManager? = null
    private val mAudioFocusChangeListener: AudioManager.OnAudioFocusChangeListener = AudioManager.OnAudioFocusChangeListener {
        when(it){
            AudioManager.AUDIOFOCUS_GAIN -> mediaPlayer?.start()
            AudioManager.AUDIOFOCUS_LOSS -> {
                mediaPlayer?.stop()
                releaseMediaPlayer()
            }
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT,
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> {
                mediaPlayer?.pause()
                mediaPlayer?.seekTo(0)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)

        audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager?

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
            if (AudioManager.AUDIOFOCUS_REQUEST_GRANTED == audioManager?.requestAudioFocus(mAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)) {
                mediaPlayer = MediaPlayer.create(this, words[position].audioRessourdeId)
                mediaPlayer?.start()
                mediaPlayer?.setOnCompletionListener(mCompletionListener)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        releaseMediaPlayer()
        audioManager = null
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private fun releaseMediaPlayer() {
        mediaPlayer?.release()  // kotlin safe-call operator
        mediaPlayer = null
        audioManager?.abandonAudioFocus(mAudioFocusChangeListener)
    }
}
