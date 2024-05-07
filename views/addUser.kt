package com.sergio.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Add_user(){
    LazyColumn( modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF96C0CE))){

        item {
            Text(text = "Add user", fontSize = 17.sp, modifier = Modifier.padding(start = 10.dp, top = 10.dp))
        }
        item {
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 10.dp, end = 10.dp)
                .border(
                    BorderStroke(2.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.extraSmall //Forma del borde de la fila
                )
            ){
                Text(text = "Enter user's name",color = Color.Gray,modifier = Modifier.padding(start = 10.dp, top = 8.dp))
            }
        }

        item {
            LazyRow(modifier = Modifier.padding(start = 10.dp, top = 5.dp)) {
                item {
                    // Botón NEW TASK
                    TextButton(
                        onClick = { /* Manejar clic */ },
                        modifier = Modifier
                            .width(370.dp)
                            .background(Color.Black, shape = RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.White) // Texto blanco
                    ) {
                        Text("ADD", color = Color.White)
                    }
                }
            }
        }

        item {
            Text(text = "Add Group", fontSize = 17.sp, modifier = Modifier.padding(start = 10.dp, top = 10.dp))
        }
        item {
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 10.dp, end = 10.dp)
                .border(
                    BorderStroke(2.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.extraSmall //Forma del borde de la fila
                )
            ){
                Text(text = "Enter user's name",color = Color.Gray,modifier = Modifier.padding(start = 10.dp, top = 8.dp))
            }
        }

        item {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.small //Forma del borde de la fila
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = "user"
                )
                Text(text = "Pepito", fontSize = 18.sp, color = Color.DarkGray)
            }
        }

        item {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.small //Forma del borde de la fila
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = "user"
                )
                Text(text = "Juan Castro", fontSize = 18.sp, color = Color.DarkGray)
            }
        }

        item{
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
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
                Text(text = "Alex Pereira", fontSize = 18.sp, color = Color.DarkGray)
            }
        }

        item{
            Spacer(modifier = Modifier.height(10.dp))
            LazyRow(
                modifier = Modifier.padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    // Botón ADD GROUP
                    TextButton(
                        onClick = { /* Manejar clic */ },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Black, shape = RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.White) // Texto blanco
                    ) {
                        Text(text = "CANCEL", color = Color.White)
                    }
                }
                item {
                    // Botón ADD USER
                    TextButton(
                        onClick = { /* Manejar clic */ },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.White, shape = RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.White) // Texto blanco
                    ) {
                        Text(text = "SAVE", color = Color.Black)
                    }
                }
            }
        }

    }
}