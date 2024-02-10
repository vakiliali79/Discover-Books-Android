package com.alivakili.discover_books.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class LibraryModel(
    @SerializedName("categories")
    val categories: List<Category?>? = listOf()
) {
    @Parcelize
    data class Category(
        @SerializedName("books")
        val books: List<Book?>? = listOf(),
        @SerializedName("name")
        val name: String? = ""
    ) : Parcelable {
        @Parcelize
        data class Book(
            @SerializedName("author")
            val author: String? = "",
            @SerializedName("averageRating")
            val averageRating: Double? = 0.0,
            @SerializedName("categories")
            val categories: List<String?>? = listOf(),
            @SerializedName("collectionId")
            val collectionId: String? = "",
            @SerializedName("dateAddedToFirebase")
            val dateAddedToFirebase: String? = "",
            @SerializedName("dateAddedToLocalDB")
            val dateAddedToLocalDB: String? = "",
            @SerializedName("description")
            val description: String? = "",
            @SerializedName("goodReadsBookId")
            val goodReadsBookId: String? = "",
            @SerializedName("image")
            val image: String? = "",
            @SerializedName("isFavorite")
            val isFavorite: Boolean? = false,
            @SerializedName("isLent")
            val isLent: Boolean? = false,
            @SerializedName("isRead")
            val isRead: Boolean? = false,
            @SerializedName("isbn")
            val isbn: String? = "",
            @SerializedName("pageCount")
            val pageCount: Int? = 0,
            @SerializedName("publicationDate")
            val publicationDate: String? = "",
            @SerializedName("publisher")
            val publisher: String? = "",
            @SerializedName("ratingCount")
            val ratingCount: Int? = 0,
            @SerializedName("title")
            val title: String? = ""
        ) : Parcelable
    }
}