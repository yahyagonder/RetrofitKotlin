package com.yahyagonder.kotlinretrofit.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yahyagonder.kotlinretrofit.R
import com.yahyagonder.kotlinretrofit.model.CryptoModel

class RecyclerAdapter(private val cryptoList: ArrayList<CryptoModel>, private var listener: Listener): RecyclerView.Adapter<RecyclerAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    private val colors: Array<String> = arrayOf("#13bd27", "#29c1e1", "#b129e1", "#d3df13", "#f6bd0c", "#a1fb93", "#0d9de3", "#ffe48f")

    class RowHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel: CryptoModel, colors: Array<String>, position: Int, listener: Listener) {

            itemView.setOnClickListener {
                listener.onItemClick(cryptoModel)
            }

            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))

            var textName = itemView.findViewById<TextView>(R.id.text_name)
            var textPrice = itemView.findViewById<TextView>(R.id.text_price)

            textName.text = cryptoModel.currency
            textPrice.text = cryptoModel.price

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return RowHolder(view)
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.bind(cryptoList[position],colors,position,listener)

    }

}