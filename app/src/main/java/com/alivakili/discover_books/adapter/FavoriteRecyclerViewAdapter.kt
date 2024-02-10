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

class FavoriteRecyclerViewAdapter (
    private val items: List<ProfileModel.Favorite?>?,
    private val onClicked: (ProfileModel.Favorite) -> Unit,
    private val context: Context,
) : RecyclerView.Adapter<FavoriteRecyclerViewAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            FavoriteViewHolder {
        return FavoriteViewHolder.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val book = items?.get(position)
        if (book != null) {
            holder.bind(book)
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class FavoriteViewHolder(
        private val binding: SingleImageItemListBinding,
        private val onClicked: (ProfileModel.Favorite) -> Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: ProfileModel.Favorite) {
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
                onClicked: (ProfileModel.Favorite) -> Unit,
                context: Context
            ): FavoriteViewHolder {
                val binding = SingleImageItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return FavoriteViewHolder(
                    binding = binding,
                    onClicked = onClicked,
                    context = context
                )
            }
        }
    }


}