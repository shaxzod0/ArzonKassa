package uz.dastyor.arzonkassa.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import uz.dastyor.arzonkassa.R


class HeaderAdapter:RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {
    class HeaderViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val carousel: ImageCarousel = view.findViewById(R.id.carousel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.header_layout, parent,false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.carousel
    }

    override fun getItemCount(): Int {
        return 1
    }
}