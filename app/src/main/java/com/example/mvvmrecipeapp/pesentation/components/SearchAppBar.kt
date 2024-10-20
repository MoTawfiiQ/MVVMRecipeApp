package com.example.mvvmrecipeapp.pesentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mvvmrecipeapp.pesentation.ui.FoodCategory
import com.example.mvvmrecipeapp.pesentation.ui.getAllFoodCategories
import kotlinx.coroutines.launch
import java.util.Locale.Category

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SearchAppBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    categoryScrollPosition: Float,
    selectedCategory: FoodCategory?,
    onSelectedCategoryChanged: (String) -> Unit,
    onChangeCategoryScrollPosition: (Float) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(8.dp, MaterialTheme.shapes.medium),
        color = Color.White
    ) {
        Column {
            Row {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(8.dp),
                    value = query,
                    onValueChange = {
                        onQueryChange(it)
                    },
                    label = {
                        Text(text = "Search")
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text, imeAction = ImeAction.Done
                    ),
                    leadingIcon = {
                        Icon(Icons.Filled.Search, "Search")
                    },
                    keyboardActions = KeyboardActions(onDone = {
                        onExecuteSearch()
                    }),
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White, // Change the color when focused
                        unfocusedContainerColor = Color.LightGray, // Change the color when not focused
                        disabledContainerColor = Color.Gray // Change the color when disabled
                    ),

                    )

            }

            val scrollState = rememberScrollState()
            val coroutineScope = rememberCoroutineScope()

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)
                    .padding(start = 8.dp, bottom = 8.dp)

            ) {
                coroutineScope.launch {
                    scrollState.scrollTo(categoryScrollPosition.toInt())
                }
                for (category in getAllFoodCategories()) {
                    FoodCategoryChip(
                        category = category.value,
                        isSelected = selectedCategory == category,
                        onSelectCategoryChanged = {
                            onSelectedCategoryChanged(it)
                            onChangeCategoryScrollPosition(scrollState.value.toFloat())
                        },
                        onExecuteSearch = {
                            onExecuteSearch()
                        },
                    )
                }
            }
        }
    }
}