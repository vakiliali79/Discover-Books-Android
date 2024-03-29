package com.alivakili.discover_books.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.Model.ProfileModel
import com.alivakili.discover_books.databinding.SingleImageItemListBinding
import com.bumptech.glide.Glide

class RecentlyAddedRecyclerViewAdapter(
    private val items: List<ProfileModel.RecentlyAdded?>?,
    private val onClicked: (ProfileModel.RecentlyAdded) -> Unit,
    private val context: Context,
) : RecyclerView.Adapter<RecentlyAddedRecyclerViewAdapter.RecentlyAddedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecentlyAddedViewHolder {
        return RecentlyAddedViewHolder.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: RecentlyAddedViewHolder, position: Int) {
        val book = items?.get(position)
        if (book != null) {
            holder.bind(book)
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class RecentlyAddedViewHolder(
        private val binding: SingleImageItemListBinding,
        private val onClicked: (ProfileModel.RecentlyAdded) -> Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: ProfileModel.RecentlyAdded) {
            binding.apply {
                loadImage(book.image,context,binding.image)
                root.setOnClickListener(View.OnClickListener {
                    onClicked(book)
                })

            }
        }

        private fun loadImage(url: String?, context: Context, imageView: ImageView) {
            Glide.with(context)
                .load(url).centerCrop()
                .into(imageView)

        }

        companion object {
            fun create(
                parent: ViewGroup,
                onClicked: (ProfileModel.RecentlyAdded) -> Unit,
                context: Context
            ): RecentlyAddedViewHolder {
                val binding = SingleImageItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return RecentlyAddedViewHolder(
                    binding = binding,
                    onClicked = onClicked,
                    context = context
                )
            }
        }
    }


}