package com.example.cans_industries.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.cans_industries.Activity.DetailActivity
import com.example.cans_industries.Domain.DoctorsModel
import com.example.cans_industries.databinding.ViewholderTopDoctorBinding
import com.example.cans_industries.databinding.ViewholderTopDoctors2Binding

class TopDoctorAdapter2(val items : MutableList<DoctorsModel>):RecyclerView.Adapter<TopDoctorAdapter2.Viewholder>() {

    private var context:Context?=null

    class Viewholder(val binding:ViewholderTopDoctors2Binding)
        : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding=ViewholderTopDoctors2Binding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.nameTxt.text = items[position].Name
        holder.binding.specialTxt.text = items[position].Special
        holder.binding.scoreTxt.text = items[position].Rating.toString()
        holder.binding.ratingBar.rating=items[position].Rating.toFloat()
        holder.binding.scoreTxt.text=items[position].Rating.toString()
        holder.binding.degreeTxt.text="Professional Doctor"

        Glide.with(holder.itemView.context)
            .load(items[position].Picture)
            .apply{
                RequestOptions().transform(CenterCrop())
            }
            .into(holder.binding.img)

        holder.binding.makeBtn.setOnClickListener{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("Object",items[position])
            context?.startActivity(intent)
        }
    }
}