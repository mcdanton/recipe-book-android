package com.recipe_book

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recipe_book.R
import javax.inject.Inject

class RecommendFoodActivity: AppCompatActivity() {

    private val meatButton: Button by lazy { findViewById<Button>(R.id.buttonMeat) }
    private val dairyButton: Button by lazy { findViewById<Button>(R.id.buttonDairy) }
    private val pareveButton: Button by lazy { findViewById<Button>(R.id.buttonPareve) }

    @Inject
    lateinit var presenter: RecommendFoodPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest_meal)

        title = "Suggest Meal"

        (application as App).appComponent.inject(this)

        setViewListeners()
    }

    private fun setViewListeners() {
        meatButton.isSelected = true
        dairyButton.isSelected = true
        pareveButton.isSelected = true

        meatButton.setOnClickListener {
            it.isSelected = !it.isSelected
        }
        dairyButton.setOnClickListener {
            it.isSelected = !it.isSelected
        }
        pareveButton.setOnClickListener {
            it.isSelected = !it.isSelected
        }
    }

}