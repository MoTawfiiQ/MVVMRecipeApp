package com.example.mvvmrecipeapp.pesentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mvvmrecipeapp.pesentation.ui.FoodCategory

@Composable
fun FoodCategoryChip (
    category: String,
    isSelected: Boolean = false,
    onSelectCategoryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit
) {
    Surface (
        modifier = Modifier.padding(end = 8.dp),
        tonalElevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if(isSelected) Color.LightGray else MaterialTheme.colorScheme.primary
    ){
        Row(
            modifier = Modifier.toggleable (
                value = isSelected,
                onValueChange = {
                    onSelectCategoryChanged(category)
                    onExecuteSearch()
                }
            )
        ){
            Text(
                text = category,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}