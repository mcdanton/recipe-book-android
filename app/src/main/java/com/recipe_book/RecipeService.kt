package com.recipe_book

import javax.inject.Inject

class RecipeService @Inject constructor(
    private val recipeDao: RecipeDao
) {

    fun saveRecipe(recipe: Recipe) {
        recipeDao.insertAll(recipe)
    }
    
}