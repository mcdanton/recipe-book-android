package com.recipe_book

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AppCompatActivity
import com.example.recipe_book.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_suggest_meal.*
import javax.inject.Inject

class RecommendFoodActivity : AppCompatActivity(), RecommendFoodPresenter.View {

    private val meatButton: Button by lazy { findViewById<Button>(R.id.buttonMeat) }
    private val dairyButton: Button by lazy { findViewById<Button>(R.id.buttonDairy) }
    private val pareveButton: Button by lazy { findViewById<Button>(R.id.buttonPareve) }
    private val addFoodButton: FloatingActionButton by lazy { findViewById<FloatingActionButton>(R.id.fab) }

    @Inject
    lateinit var presenter: RecommendFoodPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggest_meal)

        title = getString(R.string.suggest_meal_activity_title)

        (application as App).appComponent.inject(this)

        setupCookTimeNumberPicker()
        setViewListeners()
    }

    override fun onStart() {
        super.onStart()
        presenter.onViewAttached(this)
    }

    private fun setupCookTimeNumberPicker() {
        val hoursNumberPicker = findViewById<NumberPicker>(R.id.hours_number_picker)
        val minutesNumberPicker = findViewById<NumberPicker>(R.id.minutes_number_picker)

        hoursNumberPicker.minValue = 0
        hoursNumberPicker.maxValue = 24

        minutesNumberPicker.minValue = 0
        minutesNumberPicker.maxValue = 59
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

        addFoodButton.setOnClickListener {
            val intent = Intent(this, AddRecipeActivity::class.java)
            startActivity(intent)
        }

        button_surprise_me.setOnClickListener {
            val classificationList: List<KosherClassification> =
                listOf(meatButton, dairyButton, pareveButton)
                    .filter { it.isSelected }
                    .map {
                        when (it) {
                            meatButton -> KosherClassification.MEAT
                            dairyButton -> KosherClassification.MILK
                            pareveButton -> KosherClassification.PAREVE
                            else -> KosherClassification.PAREVE
                        }
                    }
            presenter.showRecipes(classificationList)
        }
    }

    override fun showResults(recipes: List<Recipe>) {
        textViewFoodResults.text = recipes.toString()
    }

}