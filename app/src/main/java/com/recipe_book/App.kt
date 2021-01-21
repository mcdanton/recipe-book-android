package com.recipe_book

import android.app.Application
import com.example.recipe_book.BuildConfig
import com.recipe_book.dependencyinjection.AppComponent
import com.recipe_book.dependencyinjection.AppModule
import com.recipe_book.dependencyinjection.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)
        initTimber()
    }

    private fun initDagger(app: App): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
