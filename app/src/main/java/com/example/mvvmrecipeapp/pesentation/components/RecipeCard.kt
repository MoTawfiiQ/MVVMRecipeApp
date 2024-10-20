package com.example.mvvmrecipeapp.pesentation.components

import androidx.compose.foundation.Image
import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mvvmrecipeapp.R
import com.example.mvvmrecipeapp.domain.model.Recipe
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.drawable.toBitmap
import com.example.mvvmrecipeapp.util.DEFAULT_RECIPE_IMAGE
import com.example.mvvmrecipeapp.util.loadPicture

@Composable
fun RecipeCard(
    recipe: Recipe, onClickAction: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                top = 6.dp, bottom = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = onClickAction),
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Column (){
            recipe.featuredImage?.let { url ->
                val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
                image?.toBitmap()?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = stringResource(id = R.string.empty_plate),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
            }
        }
    }
}
