package uz.dastyor.arzonkassa.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_ticket.view.*
import uz.dastyor.arzonkassa.Interface.ItemClick
import uz.dastyor.arzonkassa.MyDataItem
import uz.dastyor.arzonkassa.R

class RecyclerAdapter(private val itemClick: ItemClick,): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    var userList = ArrayList<MyDataItem>()


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var tv_from:TextView = itemView.tv_from
        var tv_to:TextView=itemView.tv_to
        var tv_price:TextView=itemView.tv_price

    }

    fun updateList(list: ArrayList<MyDataItem>) {
        userList.clear()
        userList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_from.text=userList[position].from
        holder.tv_to.text=userList[position].to
        holder.tv_price.text=userList[position].price
        holder.itemView.setOnClickListener {
            itemClick.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}
//
//class RecyclerAdapter(
// val city : Array<String>,
// private val itemClick: ItemClick,
//) :
//    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ticket, parent, false)
//        return RecyclerViewHolder(view)
//    }
//
//
//
//
//    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
//        holder.tvInternet.text = city[position]
//        holder.itemView.setOnClickListener {
//            itemClick.onItemClicked(position)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return city.size
//    }
//
//    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//        val tvInternet = itemView.findViewById<TextView>(R.id.tv_to)
//
//    }
//
//}