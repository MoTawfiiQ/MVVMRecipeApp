package com.example.mvvmrecipeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mvvmrecipeapp.pesentation.components.FoodCategoryChip
import com.example.mvvmrecipeapp.pesentation.components.RecipeCard
import com.example.mvvmrecipeapp.pesentation.components.SearchAppBar
import com.example.mvvmrecipeapp.pesentation.ui.RecipeListViewModel
import com.example.mvvmrecipeapp.pesentation.ui.getAllFoodCategories
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var application: BaseApplication

    private val viewModel: RecipeListViewModel by viewModels()


    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val recipes = viewModel.recipes.value

            val query = viewModel.query.value

            val selectedCategory = viewModel.selectedCategory.value

            Column {
                SearchAppBar(
                    query = query,
                    onQueryChange = viewModel::onQueryChange,
                    onExecuteSearch = viewModel::newSearch,
                    categoryScrollPosition = viewModel.categoryScrollPosition,
                    selectedCategory = selectedCategory,
                    onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                    onChangeCategoryScrollPosition = viewModel::onChangeCategoryScrollPosition
                )
                LazyColumn() {
                    itemsIndexed(
                        items = recipes
                    ) { index, recipe ->
                        RecipeCard(recipe = recipe, onClickAction = {})
                    }
                }

            }
        }
//        val mapper = RecipeDtoMapper()
//
//        val recipe = Recipe()
//
//        val networkEntity: RecipeDto = mapper.mapFromDomainModel(recipe)
//
//        val r: Recipe = mapper.mapToDomainModel(networkEntity)
//
//        val viewModel = RecipeListViewModel
//
//
//        setContent {
//
//            val recipes = view
//
//            LazyColumn(
//                modifier = Modifier
//                    .padding(top = 16.dp)
//                    .background(color = Color.LightGray)
//                    .fillMaxWidth()
//            ) {
//                item {
//                    Image(
//                        painter = painterResource(id = R.drawable.happy_meal_small),
//                        contentDescription = stringResource(id = R.string.happy_meal_image),
//                        modifier = Modifier.fillMaxWidth()
//
//                    )
//                }
//                item {
//                    Column(modifier = Modifier.padding(16.dp)) {
//                        Row(
//                            modifier = Modifier.fillMaxWidth(),
//                            horizontalArrangement = Arrangement.Absolute.SpaceBetween
//                        ) {
//                            Text(
//                                text = "Happy Meal",
//                                style = TextStyle(
//                                    fontSize = 26.sp
//                                ),
//                                modifier = Modifier.align(Alignment.CenterVertically)
//
//                            )
//                            Spacer(modifier = Modifier.padding(top = 10.dp))
//                            Text(
//                                text = "$5.99",
//                                style = TextStyle(
//                                    color = Color.Green,
//                                    fontSize = 17.sp
//                                )
//                            )
//
//                        }
//                        Spacer(modifier = Modifier.padding(top = 10.dp))
//                        Text(
//                            text = "800 Calories",
//                            style = TextStyle(
//                                fontSize = 17.sp
//                            )
//                        )
//                        Spacer(modifier = Modifier.padding(top = 10.dp))
//                        Button(
//                            onClick = {},
//                            modifier = Modifier.align(Alignment.CenterHorizontally)
//                        ) {
//                            Text(
//                                text = "Order Now",
//                                style = TextStyle(
//                                    fontSize = 17.sp
//                                )
//                            )
//                        }
//
//                    }
//                }
//            }
//        }
    }
}
