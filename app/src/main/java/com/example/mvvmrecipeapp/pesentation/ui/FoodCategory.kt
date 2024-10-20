package com.example.mvvmrecipeapp.pesentation.ui

enum class FoodCategory(val value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza")
}

fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(FoodCategory.CHICKEN,
        FoodCategory.BEEF, FoodCategory.SOUP, FoodCategory.DESSERT,
        FoodCategory.VEGETARIAN, FoodCategory.MILK, FoodCategory.VEGAN, FoodCategory.PIZZA
    )
}

fun getFoodCategory(value: String): FoodCategory?{
    val map = FoodCategory.entries.associateBy(FoodCategory::value)
    return map[value]
}