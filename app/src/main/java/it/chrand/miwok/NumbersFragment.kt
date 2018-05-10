package it.chrand.miwok


import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NumbersFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null
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


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.word_list, container, false)
        audioManager = getActivity()?.getSystemService(Context.AUDIO_SERVICE) as AudioManager?

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

        val itemsAdapter = WordAdapter(getActivity()!!, words, R.color.category_numbers)

        val listView = rootView.findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            releaseMediaPlayer()
            if (AudioManager.AUDIOFOCUS_REQUEST_GRANTED == audioManager?.requestAudioFocus(mAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)) {
                mediaPlayer = MediaPlayer.create(getActivity(), words[position].audioRessourdeId)
                mediaPlayer?.start()
                mediaPlayer?.setOnCompletionListener(mCompletionListener)
            }
        }

        return rootView
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
