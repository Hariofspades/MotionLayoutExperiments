package com.hariofspades.platter.feature.platter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hariofspades.platter.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.plate_item.view.*
import kotlinx.android.synthetic.main.platter_view.*

class CartAdapter : ListAdapter<String, CartAdapter.PlateViewHolder>(CartDiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PlateViewHolder {
        return PlateViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.plate_item, parent, false))
    }

    override fun onBindViewHolder(p0: PlateViewHolder, p1: Int) {
        val item = getItem(p1)

        Picasso.get()
                .load(item)
                .resize(50, 50)
                .centerCrop()
                .into(p0.prodImage)

        p0.motion.transitionToEnd()
    }

    class PlateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val prodImage = view.plate
        val motion = view.motion
    }
}