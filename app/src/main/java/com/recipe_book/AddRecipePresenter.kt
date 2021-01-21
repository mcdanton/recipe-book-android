package com.recipe_book

import timber.log.Timber
import javax.inject.Inject

class AddRecipePresenter @Inject constructor(
    private val recipeService: RecipeService
) : BasePresenter<AddRecipePresenter.AddRecipeView>() {


    override fun onViewAttached() {
        super.onViewAttached()
    }

    fun onAddButtonClicked(recipe: Recipe) {
        recipeService.saveRecipe(recipe)
    }

    interface AddRecipeView : BaseView {
    }
}