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
        words.add(Word("әpә","father"))
        words.add(Word("әṭa","mother"))
        words.add(Word("angsi","son"))
        words.add(Word("tune","daughter"))
        words.add(Word("taachi","older brother"))
        words.add(Word("chalitti","younger brother"))
        words.add(Word("teṭe","older sister"))
        words.add(Word("kolliti","younger sister"))
        words.add(Word("ama","grandmother"))
        words.add(Word("paapa","grandfather"))

        val itemsAdapter = WordAdapter(this, words)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
    }
}
