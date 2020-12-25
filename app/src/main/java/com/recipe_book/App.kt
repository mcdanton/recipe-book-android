package com.recipe_book

import android.app.Application
import androidx.room.Room
import com.recipe_book.dependencyinjection.AppComponent
import com.recipe_book.dependencyinjection.AppModule
import com.recipe_book.dependencyinjection.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
    }

    private fun initDagger(app: App): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()


    /*
    https://developer.android.com/training/data-storage/room
    val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()


        val userDao = db.userDao()
val users: List<User> = userDao.getAll()
     */
    private fun initRoomDb() {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "recipe-book-db"
        )
    }
}
