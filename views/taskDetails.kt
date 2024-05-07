package com.sergio.views

import androidx.compose.material3.TextField

import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.ContentPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.TvExtender
import androidx.navigation.NavController
import com.sergio.views.Loginscreen_2
import com.sergio.views.R
import com.sergio.views.navigation.taskNavigation
import com.sergio.views.ui.theme.ViewsTheme

@Preview
@Composable
fun Task_Details(){

    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var task by remember { mutableStateOf("") }

    Surface{

        LazyColumn( modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF96C0CE))){

            item{
                Row {
                    Text(text = "TASK DETAILS", fontSize = 32.sp,modifier = Modifier.padding(start = 10.dp),style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.ExtraBold))
                }
            }
            item{
                Text(text = "Name", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp), style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
            }
            item{
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 10.dp, end = 10.dp)

                ){
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        modifier = Modifier
                            .padding(start = 10.dp, top = 8.dp)
                            .fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Enter name",
                                color = Color.Gray
                            )
                        },
                        textStyle = TextStyle(color = Color.Black)
                    )
                }
            }
            item{
                Text(text = "Date", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp),style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
            }

            item {

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 10.dp, end = 10.dp)

                ){
                    TextField(
                        value = date,
                        onValueChange = { date = it },
                        modifier = Modifier
                            .padding(start = 10.dp, top = 8.dp)
                            .fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Select Date",
                                color = Color.Gray
                            )
                        },
                        textStyle = TextStyle(color = Color.Black)
                    )
                }

            }
            item{
                Text(text = "Task", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp),style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
            }

            item {

                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 10.dp, end = 10.dp)

                ){
                    TextField(
                        value = task,
                        onValueChange = { task = it },
                        modifier = Modifier
                            .padding(start = 10.dp, top = 8.dp)
                            .fillMaxWidth(),
                        placeholder = {
                            Text(
                                text = "Enter task",
                                color = Color.Gray
                            )
                        },
                        textStyle = TextStyle(color = Color.Black)
                    )
                }

            }

            item{
                Row(modifier = Modifier
                    .height(400.dp)
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 30.dp, end = 20.dp)
                    .background(Color.Transparent)
                    .border(
                        BorderStroke(3.dp, Color.LightGray),
                        shape = MaterialTheme.shapes.small //Forma del borde de la fila
                    )
                    .padding(start = 20.dp, top = 20.dp)){

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
                            Text(text = "ADD GROUP", color = Color.White)
                        }
                    }
                    item {
                        // Botón ADD USER
                        TextButton(
                            onClick = { /* Manejar clic */ },
                            modifier = Modifier
                                .width(180.dp)
                                .background(Color.White, shape = RoundedCornerShape(8.dp)),
                            colors = ButtonDefaults.textButtonColors(contentColor = Color.Black) // Texto blanco
                        ) {
                            Text(text = "ADD USER", color = Color.Black)
                        }
                    }
                }
            }
        }
    }
}
