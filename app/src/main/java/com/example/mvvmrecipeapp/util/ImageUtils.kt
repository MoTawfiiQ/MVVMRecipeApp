package com.example.mvvmrecipeapp.util

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.mvvmrecipeapp.R


val DEFAULT_RECIPE_IMAGE = R.drawable.empty_plate

@SuppressLint("UnrememberedMutableState")
@Composable
fun loadPicture(url: String, @DrawableRes defaultImage: Int): MutableState<Drawable?>{
    val context = LocalContext.current
    val drawableState: MutableState<Drawable?> = mutableStateOf(null)
    Glide.with(context)
        .load(defaultImage) // The URL of the image
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                drawableState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }

        })

    Glide.with(context)
        .load(url) // The URL of the image
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                drawableState.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }

        })
    return drawableState
}