package com.alivakili.discover_books.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.Model.DiscoverModel
import com.alivakili.discover_books.R
import com.alivakili.discover_books.databinding.DiscoverItemListBinding
import com.bumptech.glide.Glide

class DiscoverRecyclerViewAdapter(
    private val items: DiscoverModel,
    private val onClicked: (DiscoverModel.Book) -> Unit,
    private val context: Context,
) : RecyclerView.Adapter<DiscoverRecyclerViewAdapter.DiscoverViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            DiscoverViewHolder {
        return DiscoverViewHolder.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: DiscoverViewHolder, position: Int) {
        val tour = items.books?.get(position)
        if (tour != null) {
            holder.bind(tour)
        }
    }

    override fun getItemCount(): Int {
        return items.books?.size ?: 0
    }

    class DiscoverViewHolder(
        private val binding: DiscoverItemListBinding,
        private val onClicked: (DiscoverModel.Book) -> Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: DiscoverModel.Book) {
            binding.apply {
                author.text = book.author
                bookTitle.text = book.title
                loadImage(book.image, context,binding.image)
                rating.text = book.ratingCount.toString() + " rating"
                book.averageRating?.let { loadStars(it) }
                root.setOnClickListener(View.OnClickListener {
                    onClicked(book)
                })

            }
        }

        private fun loadStars(aRate: Double) {
            binding.apply {
                if (aRate <= 0.5) {
                    star1.setImageResource(R.drawable.baseline_star_half_24)
                    star2.setImageResource(R.drawable.baseline_star_border_24)
                    star3.setImageResource(R.drawable.baseline_star_border_24)
                    star4.setImageResource(R.drawable.baseline_star_border_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 1.0) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_border_24)
                    star3.setImageResource(R.drawable.baseline_star_border_24)
                    star4.setImageResource(R.drawable.baseline_star_border_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 1.5) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_half_24)
                    star3.setImageResource(R.drawable.baseline_star_border_24)
                    star4.setImageResource(R.drawable.baseline_star_border_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 2) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_24)
                    star3.setImageResource(R.drawable.baseline_star_border_24)
                    star4.setImageResource(R.drawable.baseline_star_border_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 2.5) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_24)
                    star3.setImageResource(R.drawable.baseline_star_half_24)
                    star4.setImageResource(R.drawable.baseline_star_border_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 3.0) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_24)
                    star3.setImageResource(R.drawable.baseline_star_24)
                    star4.setImageResource(R.drawable.baseline_star_border_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 3.5) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_24)
                    star3.setImageResource(R.drawable.baseline_star_24)
                    star4.setImageResource(R.drawable.baseline_star_half_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 4.0) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_24)
                    star3.setImageResource(R.drawable.baseline_star_24)
                    star4.setImageResource(R.drawable.baseline_star_24)
                    star5.setImageResource(R.drawable.baseline_star_border_24)
                } else if (aRate <= 4.5) {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_24)
                    star3.setImageResource(R.drawable.baseline_star_24)
                    star4.setImageResource(R.drawable.baseline_star_24)
                    star5.setImageResource(R.drawable.baseline_star_half_24)
                } else {
                    star1.setImageResource(R.drawable.baseline_star_24)
                    star2.setImageResource(R.drawable.baseline_star_24)
                    star3.setImageResource(R.drawable.baseline_star_24)
                    star4.setImageResource(R.drawable.baseline_star_24)
                    star5.setImageResource(R.drawable.baseline_star_24)
                }
            }
        }

        private fun loadImage(url: String?, context: Context,imageView: ImageView) {
            Glide.with(context)
                .load(url).centerCrop()
                .into(imageView)

        }

        companion object {
            fun create(
                parent: ViewGroup,
                onClicked: (DiscoverModel.Book) -> Unit,
                context: Context
            ): DiscoverViewHolder {
                val binding = DiscoverItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return DiscoverViewHolder(
                    binding = binding,
                    onClicked = onClicked,
                    context = context
                )
            }
        }
    }


}