package com.recipe_book

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recipe_book.R
import javax.inject.Inject

class AddRecipeActivity: AppCompatActivity() {

    @Inject
    lateinit var presenter: AddFoodPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = getString(R.string.add_recipe_activity_title)

        (application as App).appComponent.inject(this)
    }


}
