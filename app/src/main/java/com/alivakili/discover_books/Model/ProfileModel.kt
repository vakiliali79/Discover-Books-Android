package com.alivakili.discover_books.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileModel(
    @SerializedName("book_count")
    val bookCount: Int? = 0,
    @SerializedName("collections")
    val collections: Int? = 0,
    @SerializedName("favorite")
    val favorite: List<Favorite?>? = listOf(),
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("recently_added")
    val recentlyAdded: List<RecentlyAdded?>? = listOf(),
    @SerializedName("recently_read")
    val recentlyRead: List<RecentlyRead?>? = listOf()
) : Parcelable {
    @Parcelize
    data class Favorite(
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
    @Parcelize
    data class RecentlyAdded(
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
    @Parcelize
    data class RecentlyRead(
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