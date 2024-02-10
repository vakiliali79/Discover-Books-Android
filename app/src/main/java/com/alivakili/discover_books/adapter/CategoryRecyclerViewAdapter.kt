package com.alivakili.discover_books.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.Model.LibraryModel
import com.alivakili.discover_books.R
import com.alivakili.discover_books.databinding.DiscoverItemListBinding
import com.bumptech.glide.Glide

class CategoryRecyclerViewAdapter (
    private val items: LibraryModel.Category,
    private val onClicked: (LibraryModel.Category.Book) -> Unit,
    private val context: Context,
) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CategoryViewHolder {
        return CategoryViewHolder.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val book = items.books?.get(position)
        if (book != null) {
            holder.bind(book)
        }
    }

    override fun getItemCount(): Int {
        return items.books?.size ?: 0
    }

    class CategoryViewHolder(
        private val binding: DiscoverItemListBinding,
        private val onClicked: (LibraryModel.Category.Book) -> Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: LibraryModel.Category.Book) {
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
                onClicked: (LibraryModel.Category.Book) -> Unit,
                context: Context
            ): CategoryViewHolder {
                val binding = DiscoverItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CategoryViewHolder(
                    binding = binding,
                    onClicked = onClicked,
                    context = context
                )
            }
        }
    }


}