package com.example.mvvmrecipeapp.network.model

import com.example.mvvmrecipeapp.domain.model.Recipe
import com.example.mvvmrecipeapp.domain.util.DomainMapper

class RecipeDtoMapper : DomainMapper<RecipeDto, Recipe>{
    override fun mapToDomainModel(model: RecipeDto): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            publisher = model.publisher,
            featuredImage = model.featuredImage,
            rating = model.rating,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients?: listOf(),
            dataAdded = model.dataAdded,
            dataUpdated = model.dataUpdated
        )
    }

    override fun mapFromDomainModel(domainModel: Recipe): RecipeDto {
        return RecipeDto(
            pk = domainModel.id,
            title = domainModel.title,
            publisher = domainModel.publisher,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dataAdded = domainModel.dataAdded,
            dataUpdated = domainModel.dataUpdated
        )
    }

    fun  toDomainList(initial: List<RecipeDto>): List<Recipe>{
        return initial.map { mapToDomainModel(it) }
    }

    fun  fromDomainList(initial: List<Recipe>): List<RecipeDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}