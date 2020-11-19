package com.recipe_book

abstract class BasePresenter<ViewT: BaseView> {

    var view: ViewT? = null

    open fun onViewAttached(){}

    open fun onViewDetached(){}

}