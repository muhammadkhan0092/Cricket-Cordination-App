package com.example.fyp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fyp.data.MainData
import com.example.fyp.data.MainData2
import com.example.fyp.data.MainData3
import com.example.fyp.databinding.RsBrandsItemBinding
import com.example.fyp.databinding.RvCricketItemBinding
import com.example.fyp.databinding.RzBrandsItemBinding


class StoreAdapter : RecyclerView.Adapter<StoreAdapter.CricketViewHolder>(){

    inner class CricketViewHolder(val binding : RzBrandsItemBinding) : RecyclerView.ViewHolder(binding.root){
    }

    private val diffUtil =object : DiffUtil.ItemCallback<MainData3>(){
        override fun areItemsTheSame(oldItem: MainData3, newItem: MainData3): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: MainData3, newItem: MainData3): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CricketViewHolder {
        return CricketViewHolder(
            RzBrandsItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: CricketViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.binding.apply {
            cv.setImageResource(item.image)
            textView20.text = item.name
            textView21.text = item.Price
            textView22.text = item.rating
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick : ((MainData3) -> Unit)? = null


}