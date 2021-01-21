package com.recipe_book

import androidx.room.*

@Dao
interface RecipeDao {

    @Query("Select * from recipe")
    fun getAll(): List<Recipe>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(recipe: Recipe): Long

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipes(vararg recipes: Recipe): List<Long>

    @Delete
    fun delete(recipe: Recipe)

//    fun deleteAll()
//
//    fun get()
//
//    fun add()

}
