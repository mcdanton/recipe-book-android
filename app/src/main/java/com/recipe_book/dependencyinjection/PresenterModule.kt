package com.recipe_book.dependencyinjection

import com.recipe_book.AddRecipePresenter
import com.recipe_book.RecommendFoodPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Provides
    @Singleton
    fun provideRecommendFoodPresenter(): RecommendFoodPresenter = RecommendFoodPresenter()

    @Provides
    @Singleton
    fun provideAddFoodPresenter(): AddRecipePresenter = AddRecipePresenter()
}
