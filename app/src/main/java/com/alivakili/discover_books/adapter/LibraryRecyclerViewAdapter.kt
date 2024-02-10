package com.alivakili.discover_books.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.Model.LibraryModel
import com.alivakili.discover_books.databinding.LibraryItemListBinding
import com.bumptech.glide.Glide

class LibraryRecyclerViewAdapter (
    private val items: LibraryModel,
    private val onClicked: (LibraryModel.Category) -> Unit,
    private val context: Context,
) : RecyclerView.Adapter<LibraryRecyclerViewAdapter.LibraryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            LibraryViewHolder {
        return LibraryViewHolder.create(parent, onClicked, context)
    }

    override fun onBindViewHolder(holder: LibraryViewHolder, position: Int) {
        val category = items.categories?.get(position)
        if (category != null) {
            holder.bind(category)
        }
    }

    override fun getItemCount(): Int {
        return items.categories?.size ?: 0
    }

    class LibraryViewHolder(
        private val binding: LibraryItemListBinding,
        private val onClicked: (LibraryModel.Category) -> Unit,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: LibraryModel.Category) {
            binding.apply {
                name.text=book.name
                numOfBooks.text=book.books?.size.toString()
                if (book.books!!.isNotEmpty())
                loadImage(book.books?.get(0)?.image,context,binding.image)
                root.setOnClickListener(View.OnClickListener {
                    onClicked(book)
                })

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
                onClicked: (LibraryModel.Category) -> Unit,
                context: Context
            ): LibraryViewHolder {
                val binding = LibraryItemListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return LibraryViewHolder(
                    binding = binding,
                    onClicked = onClicked,
                    context = context
                )
            }
        }
    }


}