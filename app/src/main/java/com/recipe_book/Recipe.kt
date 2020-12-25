package com.recipe_book

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey
    val id: String,
    var name: String,
    var ingredients: List<String>,
    var cookTime: String?,
    var servings: String?,
    var instructions: String?,
    var image: String?
)