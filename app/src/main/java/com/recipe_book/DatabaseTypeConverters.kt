package com.recipe_book

import androidx.room.TypeConverter
import com.google.gson.Gson


class DatabaseTypeConverters {

    @TypeConverter
    fun toIngredientsList(value: String): List<String> =
        Gson().fromJson(value, Array<String>::class.java).toList()


    @TypeConverter
    fun fromIngredientsList(value: List<String>) = Gson().toJson(value)

    /*
    @TypeConverter
    fun fromString(string: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun fromList(list: List<String>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
    */

    @TypeConverter
    fun toKosherClassification(value: Int): KosherClassification = enumValues<KosherClassification>()[value]


    @TypeConverter
    fun fromKosherClassification(value: KosherClassification) = value.ordinal


}