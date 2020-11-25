package com.recipe_book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipe_book.R
import javax.inject.Inject

class RecommendFoodActivity: AppCompatActivity() {

    @Inject
    lateinit var presenter: RecommendFoodPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest_meal)

        (application as App).appComponent.inject(this)
    }

}