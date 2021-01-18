package com.idn.smart.tiyas.restofinders.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.idn.smart.tiyas.restofinders.R
import com.idn.smart.tiyas.restofinders.model.ModelReview
import kotlinx.android.synthetic.main.list_item_review.view.*

class ReviewAdapter (

    private val mContext: Context, private val items: List<ModelReview>) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    private var Rating = 0.0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_review, parent, false)
        return ViewHolder(view)
    }

    //Class Holder
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgProfile: ImageView = itemView.imgProfile
        var tvNameUser: TextView = itemView.tvNameUser
        var tvTimeReview: TextView = itemView.tvTimeReview
        var tvRatingReview: TextView = itemView.tvRatingReview
        var tvReview: TextView = itemView.tvReview
        var ratingReview: RatingBar = itemView.ratingReview
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val data = items[position]

        Rating = data.ratingReview

        Glide.with(mContext)
            .load(data.profileImage)
            .circleCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imgProfile)

        val newValue = Rating.toFloat()
        holder.ratingReview.numStars = 5
        holder.ratingReview.stepSize = 0.5.toFloat()
        holder.ratingReview.rating = newValue

        holder.tvNameUser.text = data.nameUser
        holder.tvTimeReview.text = data.reviewTime
        holder.tvReview.text = data.reviewText
        holder.tvRatingReview.text = " |  " + data.ratingReview
    }

    override fun getItemCount(): Int {
        return items.size
    }


}