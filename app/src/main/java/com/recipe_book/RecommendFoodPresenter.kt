package com.recipe_book

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class RecommendFoodPresenter @Inject constructor(
    private val recipeService: RecipeService
) : BasePresenter<RecommendFoodPresenter.View>() {

    override fun onViewAttached(view: View) {
        super.onViewAttached(view)
        Timber.d("@@@ Attaching view")
    }


    fun showRecipes(kosherClassification: List<KosherClassification>) {
        GlobalScope.launch(Dispatchers.Main) {
            val recipes = recipeService.fetchAllRecipes(kosherClassification)
            view?.showResults(recipes)
        }
    }

    interface View : BaseView {
        fun showResults(recipes: List<Recipe>)
    }
}
