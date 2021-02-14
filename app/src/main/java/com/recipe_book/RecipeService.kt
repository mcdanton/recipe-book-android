package com.recipe_book

import kotlinx.coroutines.*
import timber.log.Timber
import javax.inject.Inject

class RecipeService @Inject constructor(
    private val recipeDao: RecipeDao
) {

    fun saveRecipe(recipe: Recipe) {
        GlobalScope.launch(Dispatchers.IO) {
            recipeDao.insertRecipe(recipe)
        }
    }

    suspend fun fetchAllRecipes(kosherClassification: List<KosherClassification>): List<Recipe> =
        withContext(Dispatchers.IO) {
            Timber.d("@@@ Fetching Recipes")
            recipeDao.getAll(kosherClassification)
        }

}