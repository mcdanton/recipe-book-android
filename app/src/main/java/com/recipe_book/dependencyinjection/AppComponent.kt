package com.recipe_book.dependencyinjection

import com.recipe_book.RecommendFoodActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class])
interface AppComponent {

    fun inject(activity: RecommendFoodActivity)
}