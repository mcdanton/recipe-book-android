package com.recipe_book

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var name: String,
    var ingredients: List<String>,
    var kosherClassification: KosherClassification,
    var cookTime: String?,
    var servings: String?,
    var instructions: String?,
    var image: String?
)

enum class KosherClassification {
    MEAT,
    MILK,
    PAREVE;
}
