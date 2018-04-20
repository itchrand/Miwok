package it.chrand.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class NumbersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)

        // Create an array of words
        val words = ArrayList<Word>()
        words.add(Word("lutti","one"))
        words.add(Word("otiiko","two"))
        words.add(Word("tolookosu","three"))
        words.add(Word("oyyisa","four"))
        words.add(Word("massokka","five"))
        words.add(Word("temmokka","six"))
        words.add(Word("kenekaku","seven"))
        words.add(Word("kawinta","eight"))
        words.add(Word("wo’e","nine"))
        words.add(Word("na’aacha","ten"))

        val itemsAdapter = WordAdapter(this, words)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
    }
}
