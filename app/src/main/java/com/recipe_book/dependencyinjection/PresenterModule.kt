package com.recipe_book.dependencyinjection

import com.recipe_book.AddRecipePresenter
import com.recipe_book.RecipeService
import com.recipe_book.RecommendFoodPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Singleton
    @Provides
    fun provideRecommendFoodPresenter(): RecommendFoodPresenter = RecommendFoodPresenter()

    @Singleton
    @Provides
    fun provideAddFoodPresenter(recipeService: RecipeService): AddRecipePresenter = AddRecipePresenter(recipeService)
}
