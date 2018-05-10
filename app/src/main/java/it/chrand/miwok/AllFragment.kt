package it.chrand.miwok


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AllFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.word_list, container, false)

        // Create an array of words
        val words = ArrayList<Word>()
        words.add(Word("not yet implemented", "sorry!", -1, R.mipmap.ic_launcher))

        val itemsAdapter = WordAdapter(activity!!, words, R.color.category_all)

        val listView = rootView.findViewById<View>(R.id.list) as ListView

        listView.setAdapter(itemsAdapter)

        return rootView
    }
}
