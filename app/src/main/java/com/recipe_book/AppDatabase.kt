package com.recipe_book

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Recipe::class], version = 1)
@TypeConverters(DatabaseTypeConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao

    companion object {
        const val DB_NAME = "app-db"
    }
}
