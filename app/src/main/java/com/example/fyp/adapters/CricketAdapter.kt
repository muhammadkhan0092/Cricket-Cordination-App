package com.example.fyp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fyp.data.MainData
import com.example.fyp.data.User
import com.example.fyp.databinding.RsBrandsItemBinding
import com.example.fyp.databinding.RvCricketItemBinding


class CricketAdapter : RecyclerView.Adapter<CricketAdapter.CricketViewHolder>(){

    inner class CricketViewHolder(val binding : RvCricketItemBinding) : RecyclerView.ViewHolder(binding.root){
    }

    private val diffUtil =object : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
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
            if(!item.image.isNullOrEmpty()){
                Glide.with(holder.itemView).load(item.image).into(cv)
            }
            textView20.text = item.name
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    var onClick : ((User) -> Unit)? = null


}