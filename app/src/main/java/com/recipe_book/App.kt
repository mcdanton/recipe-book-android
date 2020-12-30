package com.recipe_book

import android.app.Application
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

}
