package com.sergio.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun user_list(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF96C0CE))){
        item{
            TopAppBar(title = { Text(text = "User avilability list", color = colorResource(id = R.color.black)) })
        }

        item {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.small //Forma del borde de la fila
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = "user"
                )
                Text(text = "Pepito\nAvaliable", fontSize = 23.sp, color = Color.DarkGray)
            }
        }

        item {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.small //Forma del borde de la fila
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = "user"
                )
                Text(text = "Juan Castro\nAvaliable", fontSize = 23.sp, color = Color.DarkGray)
            }
        }

        item{
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.small //Forma del borde de la fila
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = "user"
                )
                Text(text = "Alex Pereira\nAvaliable", fontSize = 23.sp, color = Color.DarkGray)
            }
        }
    }
}