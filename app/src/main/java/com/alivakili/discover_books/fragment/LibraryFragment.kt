package com.alivakili.discover_books.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.R
import com.alivakili.discover_books.Model.LibraryModel
import com.alivakili.discover_books.ReadJSONFromAssets
import com.alivakili.discover_books.adapter.LibraryRecyclerViewAdapter
import com.google.gson.Gson

class LibraryFragment : Fragment()  {
    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = inflater.inflate(R.layout.library_fragment, container, false)
        return _view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        properRecyclerView()

    }

    private fun properRecyclerView() {
        val data = Gson().fromJson(ReadJSONFromAssets(requireContext(),"data/library.json"), LibraryModel::class.java)
        val itemAdapter= LibraryRecyclerViewAdapter(data, onClicked =::categoryDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context )
        recyclerView.adapter = itemAdapter
    }

    private fun categoryDetails(category: LibraryModel.Category){

        val fragment = CategoryFragment.newInstance(category)
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        transaction.addToBackStack(null) // Add the transaction to the back stack
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) // Set an animation
        transaction.replace(R.id.contaner, fragment)

        transaction.commit()

    }

}