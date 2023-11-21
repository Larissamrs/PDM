package com.pdm.weatherapp


import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ListPage(
    viewModel: FavoriteCitiesViewModel
) {
    val cityList: List<FavoriteCity> = viewModel.cities
    LocalContext.current as? Activity

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
       items(cityList){ city ->
           FavoriteCityItem(favoriteCity = city, onClose = {
            viewModel.remove(city)
           })

       }
    }
}



@Composable
fun FavoriteCityItem(
    favoriteCity: FavoriteCity,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.Rounded.FavoriteBorder,
            contentDescription = "",

        )
        Spacer(modifier = Modifier.size(12.dp))
        Column (modifier = modifier.weight(1f)){
            Text(modifier = Modifier, text = favoriteCity.cityName, fontSize = 24.sp)
            Text(modifier = Modifier, text = favoriteCity.currentWeather, fontSize = 16.sp)
        }
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "null")

        }
    }
}

