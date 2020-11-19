package com.recipe_book

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class RecommendFoodActivity: AppCompatActivity() {

    @Inject
    lateinit var presenter: RecommendFoodPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).appComponent.inject(this)
    }

}