package com.example.mvvmrecipeapp.network.model

import com.google.gson.annotations.SerializedName

class RecipeDto (
    @SerializedName("pk")
    var pk: Int? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("publisher")
    var publisher: String? = null,

    @SerializedName("featured_image")
    var featuredImage: String? = null,

    @SerializedName("rating")
    var rating: Int? = null,

    @SerializedName("sourceUrl")
    var sourceUrl: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("cookingInstructions")
    var cookingInstructions: String? = null,

    @SerializedName("ingredients")
    var ingredients: List<String>? = null,

    @SerializedName("dataAdded")
    var dataAdded: String? = null,

    @SerializedName("dataUpdated")
    var dataUpdated: String? = null,

    )