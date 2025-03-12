package com.example.fyp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.data.MainData
import com.example.fyp.databinding.RvCricketItemBinding


class CricketAdapter : RecyclerView.Adapter<CricketAdapter.CricketViewHolder>(){

    inner class CricketViewHolder(val binding : RvCricketItemBinding) : RecyclerView.ViewHolder(binding.root){
    }

    private val diffUtil =object : DiffUtil.ItemCallback<MainData>(){
        override fun areItemsTheSame(oldItem: MainData, newItem: MainData): Boolean {
            return oldItem.ids==newItem.ids
        }

        override fun areContentsTheSame(oldItem: MainData, newItem: MainData): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,diffUtil)



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CricketViewHolder {
        return CricketViewHolder(
            RvCricketItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: CricketViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            cv.setImageResource(item.imageGround)
            textView14.text = item.name
            textView20.text = item.Groundname
            textView21.text = item.price
            textView22.text = item.rating
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick : ((MainData) -> Unit)? = null


}