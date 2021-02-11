package com.recipe_book

abstract class BasePresenter<ViewT: BaseView> {

    var view: ViewT? = null

    open fun onViewAttached(view: ViewT){
        this.view = view
    }

    open fun onViewDetached(){}

}