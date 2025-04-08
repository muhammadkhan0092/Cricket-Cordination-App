package com.example.fyp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fyp.data.DataProduct
import com.example.fyp.data.MainData
import com.example.fyp.data.MainData2
import com.example.fyp.data.MainData3
import com.example.fyp.databinding.RsBrandsItemBinding
import com.example.fyp.databinding.RvCricketItemBinding
import com.example.fyp.databinding.RzBrandsItemBinding


class StoreAdapter : RecyclerView.Adapter<StoreAdapter.CricketViewHolder>(){

    inner class CricketViewHolder(val binding : RzBrandsItemBinding) : RecyclerView.ViewHolder(binding.root){
    }

    private val diffUtil =object : DiffUtil.ItemCallback<DataProduct>(){
        override fun areItemsTheSame(oldItem: DataProduct, newItem: DataProduct): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: DataProduct, newItem: DataProduct): Boolean {
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
            Glide.with(holder.itemView).load(item.image).into(cv)
            textView20.text = item.name
            textView21.text = item.price.toString()
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick : ((DataProduct) -> Unit)? = null


}