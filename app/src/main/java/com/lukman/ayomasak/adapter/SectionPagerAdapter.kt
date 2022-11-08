package com.lukman.ayomasak.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lukman.ayomasak.DescFragment
import com.lukman.ayomasak.IngredientsFragment
import com.lukman.ayomasak.StepsFragment

class SectionPagerAdapter(activity: AppCompatActivity, private val fragmenBundle: Bundle?):
    FragmentStateAdapter(activity){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment ?= null

        when(position){
            0 -> fragment = DescFragment()
            1 -> fragment = IngredientsFragment()
            2 -> fragment = StepsFragment()
        }

        fragment?.arguments = fragmenBundle

        return fragment as Fragment
    }
}