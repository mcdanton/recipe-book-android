package com.recipe_book

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object {
        const val DB_NAME = "app-db"
    }
}
