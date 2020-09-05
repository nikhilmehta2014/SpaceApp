package com.nikhil.spaceapp.util.extensions

import android.app.Activity
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <B : ViewDataBinding> Activity.bindContentView(@LayoutRes layout: Int): B {
    return DataBindingUtil.setContentView(this, layout)
}