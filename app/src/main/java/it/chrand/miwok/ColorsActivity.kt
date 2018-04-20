package it.chrand.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

class ColorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)

        // Create an array of words
        val words = ArrayList<Word>()
        words.add(Word("weṭeṭṭi","red"))
        words.add(Word("chokokki","green"))
        words.add(Word("ṭakaakki","brown"))
        words.add(Word("ṭopoppi","gray"))
        words.add(Word("kululli","black"))
        words.add(Word("kelelli","white"))
        words.add(Word("ṭopiisә","dusty yellow"))
        words.add(Word("chiwiiṭә","mustard yellow"))

        val itemsAdapter = WordAdapter(this, words)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
    }
}
