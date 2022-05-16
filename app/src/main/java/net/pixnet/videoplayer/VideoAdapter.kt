package net.pixnet.videoplayer

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter

class VideoAdapter (val context: Context, val list: ArrayList<View>) : PagerAdapter(){

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("Not yet implemented")
    }
}