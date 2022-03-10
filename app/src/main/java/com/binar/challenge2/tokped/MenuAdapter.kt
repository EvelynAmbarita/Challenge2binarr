package com.binar.challenge2.tokped

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.challenge2.R
import com.binar.challenge2.databinding.GojekGridViewLayoutBinding
import com.bumptech.glide.Glide

class MenuAdapter(private val context: Context,
                  private val listTitle: Array<String>,
                  private val listIcon: IntArray)
    : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    lateinit var binding: GojekGridViewLayoutBinding

    class ViewHolder(val context: Context,val binding:GojekGridViewLayoutBinding ,view: View): RecyclerView.ViewHolder(view){
        fun bind(title: String, icon: Int){
            Glide.with(context).load(icon).centerCrop().into(binding.ivGridMenuIcon)
            binding.tvGridMenuTitle.text = title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = GojekGridViewLayoutBinding.inflate(inflater, parent, false)

        return ViewHolder(context,binding,binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listTitle[position],listIcon[position])

    }

    override fun getItemCount(): Int = 9

}