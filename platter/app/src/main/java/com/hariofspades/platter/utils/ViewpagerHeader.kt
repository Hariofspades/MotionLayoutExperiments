package com.hariofspades.platter.utils

import android.content.Context
import android.support.constraint.motion.MotionLayout
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import timber.log.Timber

class ViewpagerHeader @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), ViewPager.OnPageChangeListener {

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
    ) {
        progress = (position + positionOffset) / 2
    }

    override fun onPageSelected(position: Int) {

    }


}