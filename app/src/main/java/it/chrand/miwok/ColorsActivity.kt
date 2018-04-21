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
        words.add(Word("weṭeṭṭi","red", R.drawable.color_red))
        words.add(Word("chokokki","green", R.drawable.color_green))
        words.add(Word("ṭakaakki","brown", R.drawable.color_brown))
        words.add(Word("ṭopoppi","gray", R.drawable.color_gray))
        words.add(Word("kululli","black", R.drawable.color_black))
        words.add(Word("kelelli","white", R.drawable.color_white))
        words.add(Word("ṭopiisә","dusty yellow", R.drawable.color_dusty_yellow))
        words.add(Word("chiwiiṭә","mustard yellow", R.drawable.color_mustard_yellow))

        val itemsAdapter = WordAdapter(this, words, R.color.category_colors)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
    }
}
