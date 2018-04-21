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
        words.add(Word("lutti","one", R.drawable.number_one))
        words.add(Word("otiiko","two", R.drawable.number_two))
        words.add(Word("tolookosu","three", R.drawable.number_three))
        words.add(Word("oyyisa","four", R.drawable.number_four))
        words.add(Word("massokka","five", R.drawable.number_five))
        words.add(Word("temmokka","six", R.drawable.number_six))
        words.add(Word("kenekaku","seven", R.drawable.number_seven))
        words.add(Word("kawinta","eight", R.drawable.number_eight))
        words.add(Word("wo’e","nine", R.drawable.number_nine))
        words.add(Word("na’aacha","ten", R.drawable.number_ten))

        val itemsAdapter = WordAdapter(this, words)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
    }
}
