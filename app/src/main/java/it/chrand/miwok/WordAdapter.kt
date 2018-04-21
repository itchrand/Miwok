package it.chrand.miwok

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout


class WordAdapter(val getContext: Context, val list: ArrayList<Word>, val backgroundColorId: Int) :
        ArrayAdapter<Word>(getContext, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(
                    R.layout.list_item, parent, false)

            val textContainer = listItemView!!.findViewById(R.id.text_container) as LinearLayout
            // find the color the ressourceId maps to
            val color = ContextCompat.getColor(getContext, backgroundColorId)
            textContainer.setBackgroundColor(color)
        }

        // Get the object located at this position in the list
        val currentItem = list[position]

        val miwokTextView = listItemView!!.findViewById(R.id.miwok_text) as TextView
        miwokTextView.setText(currentItem.miwokTranslation)

        val defaultTextView = listItemView.findViewById(R.id.default_text) as TextView
        defaultTextView.setText(currentItem.defaultTranslation)

        val iconImageView = listItemView.findViewById(R.id.image) as ImageView
        if (currentItem.hasImage()) {
            iconImageView.setImageResource(currentItem.imageRessourceId)
            iconImageView.visibility = View.VISIBLE     // because of reuse
        }
        else
            iconImageView.visibility = View.GONE

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView
    }
}