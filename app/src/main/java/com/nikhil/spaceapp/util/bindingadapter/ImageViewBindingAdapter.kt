package com.nikhil.spaceapp.util.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import timber.log.Timber

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    if (url != null) {
        val requestOption = RequestOptions()
        Timber.d("original image url: $url")
        Timber.d("trimmed image url: ${url.trim()}")

        Glide.with(imageView.context)
            .load(url)
            .apply(requestOption)
            .into(imageView)
    }
}