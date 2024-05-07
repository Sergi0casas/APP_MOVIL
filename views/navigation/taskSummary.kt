package com.sergio.views.navigation

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.views.R

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun task_list(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF96C0CE))) {
        item {
            TopAppBar(title = {
                Text(
                    text = "Task List",
                    color = colorResource(id = R.color.black)
                )
            })
        }

        item {

            Row(
                modifier = Modifier
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
                Text(text = "Task 1", fontSize = 23.sp, color = Color.DarkGray)
            }

        }

        item {

            Row(
                modifier = Modifier
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
                Text(text = "Task 2", fontSize = 23.sp, color = Color.DarkGray)
            }

        }

        item {
            Text(
                text = "Task summary",
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                fontSize = 23.sp
            )
        }


        item {//contenedor de task summary
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 13.dp)
                    .height(80.dp)
                    .border(
                        BorderStroke(3.dp, Color.LightGray),
                        shape = MaterialTheme.shapes.small //Forma del borde de la fila
                    )
            ) {

            }

        }


        item {
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
                        Text(text = "FILTER", color = Color.White)
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
                        Text(text = "ADD TASK", color = Color.Black)
                    }
                }
            }


        }

    }}