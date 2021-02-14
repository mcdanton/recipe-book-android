package com.recipe_book

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipe_book.R
import kotlinx.android.synthetic.main.activity_add_recipe.*
import javax.inject.Inject

class AddRecipeActivity : AppCompatActivity(), AddRecipePresenter.AddRecipeView,
    AdapterView.OnItemSelectedListener {

    @Inject
    lateinit var presenter: AddRecipePresenter
    private val foodClassificationList = listOf(
        KosherClassification.MILK.name,
        KosherClassification.MEAT.name,
        KosherClassification.PAREVE.name
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        title = getString(R.string.add_recipe_activity_title)

        (application as App).appComponent.inject(this)

        setupViews()
        setupSpinner()
    }

    private fun setupSpinner() {
        spinner_food_classification.onItemSelectedListener = this

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            foodClassificationList
        )
        spinner_food_classification.adapter = adapter
    }

    private fun setupViews() {
        button_add_recipe.setOnClickListener {
            if (edit_text_food_name.text.isNullOrBlank()) {
                Toast.makeText(this, R.string.add_recipe_no_food_name, Toast.LENGTH_LONG).show()
            } else {
                val recipe = Recipe(
                    name = edit_text_food_name.text.toString(),
                    kosherClassification = KosherClassification.valueOf(spinner_food_classification.selectedItem.toString())
                )
                presenter.onAddButtonClicked(recipe)
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

    }

    override fun exit() {
        finish()
    }


}
