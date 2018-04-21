/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.chrand.miwok

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.content.Intent
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main)

        // Find the View that shows the numbers category
        val numbers = findViewById<View>(R.id.numbers) as TextView

        // Set a click listener on that View
        numbers.setOnClickListener {
            val numbersIntent = Intent(this@MainActivity, NumbersActivity::class.java)
            startActivity(numbersIntent)
        }

        val family = findViewById<View>(R.id.family) as TextView
        family.setOnClickListener {
            val familyIntent = Intent(this@MainActivity, FamilyActivity::class.java)
            startActivity(familyIntent)
        }

        val colors = findViewById<View>(R.id.colors) as TextView
        colors.setOnClickListener {
            val colorsIntent = Intent(this@MainActivity, ColorsActivity::class.java)
            startActivity(colorsIntent)
        }

        val phrases = findViewById<View>(R.id.phrases) as TextView
        phrases.setOnClickListener {
            val phrasesIntent = Intent(this@MainActivity, PhrasesActivity::class.java)
            startActivity(phrasesIntent)
        }

        val all = findViewById<View>(R.id.all) as TextView
        all.setOnClickListener {
            val allIntent = Intent(this@MainActivity, AllActivity::class.java)
            startActivity(allIntent)
        }

    }

}
