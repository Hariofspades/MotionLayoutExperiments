package com.hariofspades.platter.feature.platter


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hariofspades.platter.R
import com.hariofspades.platter.data.Cart
import com.hariofspades.platter.data.FactoryOutlet
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.platter_view.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    lateinit var rootView: View

    private val list = FactoryOutlet.makeRecipeList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false)
        setupPager()
        setupOrderFragment()
        return rootView
    }

    private fun setupOrderFragment() {

    }

    private fun setupPager() {
        rootView.apply {
            pager.adapter = RecipeAdapter(activity!!)
            setImage(list[0].url)

            if (motionLayout != null) {
                pager.addOnPageChangeListener(motionLayout as ViewPager.OnPageChangeListener)
                pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(p0: Int) {

                    }

                    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

                    }

                    override fun onPageSelected(p0: Int) {
                        Cart.currentDish = list[p0].url
                        setImage(Cart.currentDish)
                    }

                })
            }
        }
    }

    private fun setImage(url: String) {
        Picasso.get()
                .load(url)
                .resize(200, 200)
                .centerCrop()
                .into(rootView.plates)
    }


    companion object {
        fun newInstance() = MainFragment()
    }
}
