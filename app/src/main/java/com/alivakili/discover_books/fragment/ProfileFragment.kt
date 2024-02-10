package com.alivakili.discover_books.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alivakili.discover_books.Model.DiscoverModel
import com.alivakili.discover_books.Model.LibraryModel
import com.alivakili.discover_books.Model.ProfileModel
import com.alivakili.discover_books.R
import com.alivakili.discover_books.ReadJSONFromAssets
import com.alivakili.discover_books.activity.BookDetailsActivity
import com.alivakili.discover_books.adapter.FavoriteRecyclerViewAdapter
import com.alivakili.discover_books.adapter.RecentlyAddedRecyclerViewAdapter
import com.alivakili.discover_books.adapter.RecentlyReadRecyclerViewAdapter
import com.alivakili.discover_books.databinding.ProfileFragmentBinding
import com.bumptech.glide.Glide
import com.google.gson.Gson

class ProfileFragment: Fragment()  {
    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val data = Gson().fromJson(ReadJSONFromAssets(requireContext(),"data/profile.json"), ProfileModel::class.java)
        properRecentlyAddedRecyclerView(data.recentlyAdded)
        properRecentlyReadRecyclerView(data.recentlyRead)
        properFavoriteRecyclerView(data.favorite)
        properLayout(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun properLayout(data: ProfileModel?) {
        loadImage(data?.image,requireContext(),binding.image)
        binding.name.text=data?.name
        binding.books.text=data?.bookCount.toString()
        binding.collections.text=data?.collections.toString()
    }
    private fun loadImage(url: String?, context: Context, imageView: ImageView) {
        Glide.with(context)
            .load(url).centerCrop()
            .into(imageView)

    }
    private fun properRecentlyAddedRecyclerView(data: List<ProfileModel.RecentlyAdded?>?) {

        val itemAdapter= RecentlyAddedRecyclerViewAdapter(data, onClicked =::bookDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.addedRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = itemAdapter
    }
    private fun properRecentlyReadRecyclerView(data: List<ProfileModel.RecentlyRead?>?) {
        val itemAdapter= RecentlyReadRecyclerViewAdapter(data, onClicked =::bookDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.readRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = itemAdapter
    }
    private fun properFavoriteRecyclerView(data: List<ProfileModel.Favorite?>?) {
        val itemAdapter= FavoriteRecyclerViewAdapter(data, onClicked =::bookDetails,requireContext())
        val recyclerView: RecyclerView = requireView().findViewById(R.id.favoriteRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = itemAdapter
    }

    private fun bookDetails(tempBook: ProfileModel.RecentlyAdded){
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

    private fun bookDetails(tempBook: ProfileModel.RecentlyRead){
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

    private fun bookDetails(tempBook: ProfileModel.Favorite){
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