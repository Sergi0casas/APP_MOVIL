package com.sergio.views

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sergio.views.navigation.taskScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun progress_Group(navController: NavController){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF96C0CE))){
        item{
            TopAppBar(title = { Text(text = "Group", color = colorResource(id = R.color.black)) })
        }

        item{
            Text(text = "Task", modifier = Modifier.padding(start = 10.dp, top = 30.dp), fontSize = 26.sp)
        }

        item {
            Row {


                TextButton(onClick = { }) {
                    Text(text = "Insert task", fontSize = 23.sp)
                }
            }
        }

        item{

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 20.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = "user"
                )
                Text(text = "User name", fontSize = 23.sp, color = Color.DarkGray)
            }

        }

        item{

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_boy_24),
                    contentDescription = "user"
                )
                Text(text = "User name", fontSize = 23.sp, color = Color.DarkGray)
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
                .padding(start = 0.dp, top = 0.dp)){

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp)
                ){
                    CircularProgressBar(percentage = 0.5f, number = 100)
                }

            }
        }




        item {
            Spacer(modifier = Modifier.height(25.dp))
            LazyRow(
                modifier = Modifier.padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    // Botón ADD GROUP
                    TextButton(
                        onClick = {navController.navigate(taskScreens.home.name) },
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
                        onClick = { navController.navigate(taskScreens.home.name) },
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


//function de circulo de progreso
@Composable
fun CircularProgressBar(
    percentage:Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius : Dp = 80.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 14.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
){
    var animationPlayed by remember{
        mutableStateOf(false    )
    }

    val curPercentage = animateFloatAsState(//esto cambiar el valor de la animacion
        targetValue = if(animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = animDelay
        )

    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)

    ) {
        Canvas(modifier = Modifier.size(radius* 2f)){
            drawArc(//este el arco que se le va a dar al ciruclo
                color = color,
                -90f, //donde el circulo comienza
                360 * curPercentage.value, //este es el grado actual donde comienza el barrido
                useCenter = false , //esto es para vaciar el centro
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        //Texto en el centro de el circulo
        Text(text = (curPercentage.value * number).toInt().toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }


}
