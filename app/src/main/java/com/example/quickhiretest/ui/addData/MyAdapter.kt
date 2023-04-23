package com.example.quickhiretest.ui.addData

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quickhiretest.R

class MyAdapter (private val context: Context, private var dataList: List<DataClass>) : RecyclerView.Adapter<MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_notification, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(dataList[position].dataImage)
            .into(holder.recImage)
        holder.recTitle.text = dataList[position].dataTitle
        holder.recDesc.text = dataList[position].dataDesc
        holder.recPriority.text = dataList[position].dataPriority

        holder.recCard.setOnClickListener {
            val bundle=Bundle()
            bundle.putString("Image", dataList[holder.adapterPosition].dataImage)
            bundle.putString("Description", dataList[holder.adapterPosition].dataDesc)
            bundle.putString("Title", dataList[holder.adapterPosition].dataTitle)
            bundle.putString("Priority", dataList[holder.adapterPosition].dataPriority)

            val detailFragment = DetailFragment()
            detailFragment.arguments = bundle

            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, detailFragment)
                ?.commit()


            val intent = Intent(context, DetailFragment::class.java)
            intent.putExtra("Image", dataList[holder.adapterPosition].dataImage)
            intent.putExtra("Description", dataList[holder.adapterPosition].dataDesc)
            intent.putExtra("Title", dataList[holder.adapterPosition].dataTitle)
            intent.putExtra("Priority", dataList[holder.adapterPosition].dataPriority)
            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }

    fun searchDataList(searchList: List<DataClass>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recImage: ImageView
    var recTitle: TextView
    var recDesc: TextView
    var recPriority: TextView
    var recCard: CardView
    init {
        recImage = itemView.findViewById(R.id.recImage)
        recTitle = itemView.findViewById(R.id.recTitle)
        recDesc = itemView.findViewById(R.id.recDesc)
        recPriority = itemView.findViewById(R.id.recPriority)
        recCard = itemView.findViewById(R.id.recCard)
    }
}