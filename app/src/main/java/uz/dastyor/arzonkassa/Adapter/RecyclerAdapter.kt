package uz.dastyor.arzonkassa.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import uz.dastyor.arzonkassa.Interface.ItemClick
import uz.dastyor.arzonkassa.R

class RecyclerAdapter(
 val city : Array<String>,
 private val itemClick: ItemClick,
) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return RecyclerViewHolder(view)
    }




    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.tvInternet.text = city[position]
        holder.itemView.setOnClickListener {
            itemClick.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return city.size
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvInternet = itemView.findViewById<TextView>(R.id.tv_to)

    }

}