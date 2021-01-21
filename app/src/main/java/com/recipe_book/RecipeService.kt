package com.recipe_book

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class RecipeService @Inject constructor(
    private val recipeDao: RecipeDao
) {

    fun saveRecipe(recipe: Recipe) {
        Timber.d("@@@ I was called")
        GlobalScope.launch {
            recipeDao.insertRecipe(recipe)
        }
    }

}