package com.sergio.views


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun add_user(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF96C0CE))){

        Row {
            Text(text = "User Description", fontSize = 26.sp,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp))
        }

        Row(modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
            .padding(start = 20.dp, top = 20.dp, end = 20.dp)
            .background(Color.Transparent)
            .border(
                BorderStroke(3.dp, Color.LightGray),
                shape = MaterialTheme.shapes.small //Forma del borde de la fila
            )
            .padding(start = 20.dp, top = 20.dp)){

        }


            Spacer(modifier = Modifier.height(25.dp))
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
