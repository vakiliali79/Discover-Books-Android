package com.alivakili.discover_books.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.Model.DiscoverModel
import com.alivakili.discover_books.R
import com.alivakili.discover_books.ReadJSONFromAssets
import com.alivakili.discover_books.activity.BookDetailsActivity
import com.alivakili.discover_books.adapter.DiscoverRecyclerViewAdapter
import com.google.gson.Gson

class DiscoverFragment: Fragment()  {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.discover_fragment, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        properRecyclerView()

    }

    private fun properRecyclerView() {
        val data = Gson().fromJson(ReadJSONFromAssets(requireContext(),"data/discover.json"), DiscoverModel::class.java)
        val itemAdapter= DiscoverRecyclerViewAdapter(data, onClicked =::bookDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context )
        recyclerView.adapter = itemAdapter
    }

    private fun bookDetails(book: DiscoverModel.Book){
        Log.e("TAG", "bookDetails: "+book.title, )
        var intent= Intent(requireContext(), BookDetailsActivity::class.java)
        intent.putExtra("KEY_BOOK",book)
        startActivity(intent)
    }

}