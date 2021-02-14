package com.recipe_book

import javax.inject.Inject

class AddRecipePresenter @Inject constructor(
    private val recipeService: RecipeService
) : BasePresenter<AddRecipePresenter.AddRecipeView>() {


    fun onAddButtonClicked(recipe: Recipe) {
        recipeService.saveRecipe(recipe)
        view?.exit()
    }

    interface AddRecipeView : BaseView {
        fun exit()
    }
}