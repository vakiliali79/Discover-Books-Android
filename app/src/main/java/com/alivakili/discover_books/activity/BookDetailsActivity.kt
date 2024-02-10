package com.alivakili.discover_books.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.alivakili.discover_books.Model.DiscoverModel
import com.alivakili.discover_books.R
import com.alivakili.discover_books.databinding.ActivityBookDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso

class BookDetailsActivity : AppCompatActivity() {
    private var book: DiscoverModel.Book?=null
    private lateinit var binding:ActivityBookDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBookDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureToolbar()
        book=properData()
        properLayout()
    }

    private fun properLayout() {
        binding.apply {
            bookTitle.text=book?.title
            author.text=book?.author
            rating.text="("+book?.ratingCount.toString()+")"
            pages.text=book?.pageCount.toString()
            releaseDate.text=book?.publicationDate
            ISBN.text=book?.isbn
            description.text=book?.description
            continueReadingBtn.setOnClickListener(View.OnClickListener {

            })
        }
        loadStars(book?.averageRating)
        loadImage(item=book?.image, imageView = binding.image)
        loadBlurImage(book?.image)
    }

    private fun loadBlurImage(image: String?) {

        Glide.with(this)
            .load(image)
            .apply(
                RequestOptions.bitmapTransform(
                    jp.wasabeef.glide.transformations.BlurTransformation(
                        50,
                        3
                    )
                )
            )
            .into(binding.blurImage)
        }

    private fun loadStars(aRate: Double?) {
        binding.apply {
            if (aRate != null) {
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
    }



    private fun loadImage(imageView: ImageView, item: String?) {
        Log.e("TAG", "loadImage: "+item )
        Picasso.with(this).load(item).fit().centerCrop()
            .error(R.drawable.ic_launcher_background)
            .into(imageView);
    }


    private fun properData(): DiscoverModel.Book? {
        return intent.extras?.getParcelable("KEY_BOOK")
    }


    private fun configureToolbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title=""
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}