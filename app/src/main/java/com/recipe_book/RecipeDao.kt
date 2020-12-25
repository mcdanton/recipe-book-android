package com.recipe_book

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeDao {

    @Query("Select * from recipe")
    fun getAll(): List<Recipe>

    @Insert
    fun insertAll(vararg recipes: Recipe)

    @Delete
    fun delete(recipe: Recipe)

//    fun deleteAll()
//
//    fun get()
//
//    fun add()

}