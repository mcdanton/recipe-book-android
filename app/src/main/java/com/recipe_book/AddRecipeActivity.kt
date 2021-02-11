package com.recipe_book

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipe_book.R
import kotlinx.android.synthetic.main.activity_add_recipe.*
import javax.inject.Inject

class AddRecipeActivity : AppCompatActivity(), AddRecipePresenter.AddRecipeView {

    @Inject
    lateinit var presenter: AddRecipePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        title = getString(R.string.add_recipe_activity_title)

        (application as App).appComponent.inject(this)

        setupViews()
    }

    private fun setupViews() {
        button_add_recipe.setOnClickListener {
            if (edit_text_food_name.text.isNullOrBlank()) {
                Toast.makeText(this, R.string.add_recipe_no_food_name, Toast.LENGTH_LONG).show()
            } else {
                val recipe = Recipe(
                    name = edit_text_food_name.text.toString(),
                    kosherClassification = KosherClassification.MILK
                )
                presenter.onAddButtonClicked(recipe)
            }
        }
    }


}
