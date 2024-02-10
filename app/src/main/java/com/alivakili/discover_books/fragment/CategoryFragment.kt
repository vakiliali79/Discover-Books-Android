package com.alivakili.discover_books.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.Model.DiscoverModel
import com.alivakili.discover_books.Model.LibraryModel
import com.alivakili.discover_books.R
import com.alivakili.discover_books.activity.BookDetailsActivity
import com.alivakili.discover_books.adapter.CategoryRecyclerViewAdapter

class CategoryFragment: Fragment()  {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.category_fragment, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        properRecyclerView()

    }

    private fun properRecyclerView() {
        val data= properData()
        val itemAdapter= CategoryRecyclerViewAdapter(data!!, onClicked =::bookDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context )
        recyclerView.adapter = itemAdapter
    }
    private fun properData(): LibraryModel.Category? {
        return arguments?.getParcelable<LibraryModel.Category>("KEY_CATEGORY")
    }

    private fun bookDetails(tempBook: LibraryModel.Category.Book){
        var intent= Intent(requireContext(), BookDetailsActivity::class.java)
        var book=DiscoverModel.Book(tempBook.author,
            tempBook.averageRating,tempBook.categories,tempBook.collectionId,
            tempBook.dateAddedToFirebase, tempBook.dateAddedToLocalDB,tempBook.description,
            tempBook.goodReadsBookId,tempBook.image,tempBook.isFavorite,
            tempBook.isLent,tempBook.isRead,tempBook.isbn,
            tempBook.pageCount,tempBook.publicationDate,tempBook.publisher,
            tempBook.ratingCount,tempBook.title)
        intent.putExtra("KEY_BOOK",book)
        startActivity(intent)
    }

    companion object {
        fun newInstance(data: LibraryModel.Category): CategoryFragment {
            val fragment = CategoryFragment()
            val args = Bundle()
            args.putParcelable("KEY_CATEGORY", data)
            fragment.arguments = args
            return fragment
        }
    }
}