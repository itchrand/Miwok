package it.chrand.miwok

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter


/**
 * Provides the appropriate [Fragment] for a view pager.
 */
class SimpleFragmentPagerAdapter(val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NumbersFragment()
            1 -> FamilyFragment()
            2 -> ColorsFragment()
            3 -> PhrasesFragment()
            else -> AllFragment()
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Generate title based on item position
        return when (position) {
            0 -> context.getString(R.string.category_numbers)
            1 -> context.getString(R.string.category_family)
            2 -> context.getString(R.string.category_colors)
            3 -> context.getString(R.string.category_phrases)
            else -> context.getString(R.string.category_all)
        }
    }
}