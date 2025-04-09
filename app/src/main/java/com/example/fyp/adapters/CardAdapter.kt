package com.example.fyp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.data.MainData
import com.example.fyp.data.MainData2
import com.example.fyp.data.MainData4
import com.example.fyp.databinding.CardBrandsItemBinding
import com.example.fyp.databinding.RsBrandsItemBinding
import com.example.fyp.databinding.RvCricketItemBinding


class CardAdapter : RecyclerView.Adapter<CardAdapter.CricketViewHolder>(){

    inner class CricketViewHolder(val binding : CardBrandsItemBinding) : RecyclerView.ViewHolder(binding.root){
    }

    private val diffUtil = object : DiffUtil.ItemCallback<MainData4>(){
        override fun areItemsTheSame(oldItem: MainData4, newItem: MainData4): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: MainData4, newItem: MainData4): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CricketViewHolder {
        return CricketViewHolder(
            CardBrandsItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: CricketViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            image.setImageResource(item.image)
            pname.text = item.name
            textView43.text = item.charges
            textView42.text = item.price
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick : ((MainData4) -> Unit)? = null


}