package it.chrand.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

class FamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)

        // Create an array of words
        val words = ArrayList<Word>()
        words.add(Word("әpә","father", R.drawable.family_father))
        words.add(Word("әṭa","mother", R.drawable.family_mother))
        words.add(Word("angsi","son", R.drawable.family_son))
        words.add(Word("tune","daughter", R.drawable.family_daughter))
        words.add(Word("taachi","older brother", R.drawable.family_older_brother))
        words.add(Word("chalitti","younger brother", R.drawable.family_younger_brother))
        words.add(Word("teṭe","older sister", R.drawable.family_older_sister))
        words.add(Word("kolliti","younger sister", R.drawable.family_younger_sister))
        words.add(Word("ama","grandmother", R.drawable.family_grandmother))
        words.add(Word("paapa","grandfather", R.drawable.family_grandfather))

        val itemsAdapter = WordAdapter(this, words)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
    }
}
