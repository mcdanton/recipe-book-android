package com.recipe_book.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.recipe_book.AppDatabase
import com.recipe_book.RecipeDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, AppDatabase.DB_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideRecipeDao(appDatabase: AppDatabase): RecipeDao = appDatabase.recipeDao()
}
