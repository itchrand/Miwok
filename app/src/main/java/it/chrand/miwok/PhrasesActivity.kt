package it.chrand.miwok

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView

class PhrasesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.word_list)

        // Create an array of words
        val words = ArrayList<Word>()
        words.add(Word("minto wuksus","Where are you going?"))
        words.add(Word("tinnә oyaase'nә","What is your name?"))
        words.add(Word("oyaaset...","My name is..."))
        words.add(Word("michәksәs?","How are you feeling?"))
        words.add(Word("kuchi achit","I’m feeling good."))
        words.add(Word("әәnәs'aa?","Are you coming?"))
        words.add(Word("hәә’ әәnәm","Yes, I’m coming."))
        words.add(Word("әәnәm","I’m coming."))
        words.add(Word("yoowutis","Let’s go."))
        words.add(Word("әnni'nem","Come here."))

        val itemsAdapter = WordAdapter(this, words, R.color.category_phrases)

        val listView = findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)
    }
}
