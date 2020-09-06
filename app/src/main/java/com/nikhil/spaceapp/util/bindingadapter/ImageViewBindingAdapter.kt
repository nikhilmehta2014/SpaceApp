package com.nikhil.spaceapp.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber

const val URL_UNSPLASH =
    "https://images.unsplash.com/photo-1494253109108-2e30c049369b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    if (url != null) {
        val requestOption = RequestOptions()
        Timber.d("original image url: $url")
        Timber.d("trimmed image url: ${url.trim()}")

        //There seems to be some issue with NASA API URL format
        Glide.with(imageView.context)
//            .load(url)
            .load(URL_UNSPLASH)
            .apply(requestOption)
            .into(imageView)
    }
}