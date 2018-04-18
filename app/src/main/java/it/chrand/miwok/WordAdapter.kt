package it.chrand.miwok

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater




class WordAdapter(val getContext: Context, val list: ArrayList<Word>) :
        ArrayAdapter<Word>(getContext,0, list){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.list_item, parent, false)
        }

        // Get the object located at this position in the list
        val currentItem = list[position]

        val miwokTextView = listItemView!!.findViewById(R.id.miwok_text) as TextView
        miwokTextView.setText(currentItem!!.miwokTranslation)

        val defaultTextView = listItemView.findViewById(R.id.default_text) as TextView
        defaultTextView.setText(currentItem!!.defaultTranslation)

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView
    }
}