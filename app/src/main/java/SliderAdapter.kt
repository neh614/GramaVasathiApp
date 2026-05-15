package com.example.gramavasathi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class SliderAdapter(
    private val imageList: List<Int>
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    class SliderViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        val image =
            view.findViewById<ImageView>(R.id.slideImage)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_slider, parent, false)

        return SliderViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: SliderViewHolder,
        position: Int
    ) {

        holder.image.setImageResource(imageList[position])
    }

    override fun getItemCount(): Int {

        return imageList.size
    }
}