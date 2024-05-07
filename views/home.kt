package com.sergio.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Content(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF96C0CE)) // Azul menta
            .padding(top = 10.dp)
    ) {
        item {
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
                        Text(text = "ADD GROUP", color = Color.White)
                    }
                }
                item {
                    // Botón ADD USER
                    TextButton(
                        onClick = { /* Manejar clic */ },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Black, shape = RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.White) // Texto blanco
                    ) {
                        Text(text = "ADD USER", color = Color.White)
                    }
                }
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
                    Text(text = "NEW TASK", color = Color.White)
                }
            }
        }
        }
        item {
            LazyRow(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    // Botón People
                    TextButton(
                        onClick = { /* Manejar clic */ },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.White, shape = RoundedCornerShape(100.dp)),
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.Black) // Texto negro
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_boy_24),
                            contentDescription = "Icon group"
                        )
                        Text(text = "People", color = Color.Black)
                    }
                }
                item {
                    // Botón Task
                    TextButton(
                        onClick = { /* Manejar clic */ },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.White, shape = RoundedCornerShape(100.dp)),
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.Black) // Texto negro
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_boy_24),
                            contentDescription = "Icon group"
                        )
                        Text(text = "Task", color = Color.Black)
                    }
                }
            }
        }

        item {
            // Task list
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .width(380.dp)
                    .padding(start = 20.dp, top = 30.dp)
                    .background(Color.LightGray)
                    .border(
                        BorderStroke(2.dp, Color.LightGray),
                        shape = MaterialTheme.shapes.small //Forma del borde de la fila
                    )
                    .padding(start = 20.dp, top = 20.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    items(10) { index ->
                        Text(
                            text = "Task ${index + 1}",
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.Black
                            ),
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}
