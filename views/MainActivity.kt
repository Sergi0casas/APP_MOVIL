package com.sergio.User

import android.annotation.SuppressLint
import android.os.Bundle
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
import com.sergio.views.R
import loginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            loginScreen()
        }
        }

}





@Preview
@Composable
fun Content(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)
        .padding(top = 10.dp)){

        item{
            LazyRow(modifier = Modifier.padding(start = 10.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){
                item {
                    ExtendedFloatingActionButton(
                        onClick = {  },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),

                    ) {
                        Text(text = "   ADD GROUP  ")
                    }
                }
                item{
                    ExtendedFloatingActionButton(
                        onClick = {  },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),
                        ) {
                        Text(text = "ADD USER")
                    }
                }

            }

        }
        item {
            LazyRow(modifier = Modifier.padding(start = 10.dp, top = 5.dp)){
                item{
                    ExtendedFloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .width(370.dp)
                            .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),

                        ) {
                        Text(text = "NEW TASK")
                    }
                }
            }
        }
        item {
            LazyRow(modifier = Modifier.padding(start = 10.dp, top = 10.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){
                item {
                    ExtendedFloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(100.dp),
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_boy_24), contentDescription = "Icon group")
                        Text(text = "People")
                    }
                }
                item{
                    ExtendedFloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(100.dp)
                        ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_boy_24), contentDescription = "Icon group")
                        Text(text = "Group")
                    }
                }
            }
        }

        item {
            LazyRow(modifier = Modifier.padding(start = 10.dp, top = 10.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){
                item {
                    ExtendedFloatingActionButton(
                        onClick = {  },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(100.dp)
                    ) {
                        Icon(painter = painterResource(id = R.drawable.baseline_boy_24), contentDescription = "Icon group")
                        Text(text = "Task")
                    }
                }

            }
        }

        item{//Task list donde se ven las tareas mas recientes
            LazyRow(modifier = Modifier
                .height(400.dp)
                .width(380.dp)
                .padding(start = 20.dp, top = 30.dp)
                .background(Color.Transparent)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.small //Forma del borde de la fila
                )
                .padding(start = 20.dp, top = 20.dp)){
                item{
                    Text(text = "TASK LIST", style = TextStyle(
                        fontSize = 36.sp,
                        color = Color.Black
                    ))
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun user_list(){
    
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){
        item{
            TopAppBar(title = { Text(text = "User avilability list", color = colorResource(id = R.color.black))})
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


@Preview
@Composable
fun Task_Details(){

    Surface{

    LazyColumn( modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){

        item{
            Row {
                Text(text = "Task Details", fontSize = 32.sp,modifier = Modifier.padding(start = 10.dp))
            }
        }
        item{
            Text(text = "Name", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp))
        }
        item{
            Row (modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 10.dp, end = 10.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.extraSmall //Forma del borde de la fila
                )
            ){
                Text(text = "Enter name",color = Color.Gray,modifier = Modifier.padding(start = 10.dp, top = 8.dp))
            }
        }
        item{
            Text(text = "Date", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp))
        }

        item {

            Row (modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 10.dp, end = 10.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.extraSmall //Forma del borde de la fila
                )
            ){
                Text(text = "Select Date",color = Color.Gray,modifier = Modifier.padding(start = 10.dp, top = 8.dp))
            }

        }
        item{
            Text(text = "Task", fontSize = 16.sp, modifier = Modifier.padding(start = 10.dp))
        }

        item {

            Row (modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 10.dp, end = 10.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.extraSmall //Forma del borde de la fila
                )
            ){
                Text(text = "Enter task",color = Color.Gray,modifier = Modifier.padding(start = 10.dp, top = 8.dp))
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
            Row(modifier = Modifier.padding(start = 10.dp, top = 20.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){

                    ExtendedFloatingActionButton(
                        onClick = {  },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),

                        ) {
                        Text(text = "CANCEL")
                    }


                    ExtendedFloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .width(180.dp)
                            .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),
                    ) {
                        Text(text = "SAVE")
                    }


            }

        }

    }
    }
}
@Preview
@Composable
fun Add_user(){
    LazyColumn( modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){

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
            Row {
                ExtendedFloatingActionButton(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(90.dp)),

                    ) {
                    Text(text = "Add")
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
            Row(modifier = Modifier.padding(start = 10.dp, top = 20.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){

                ExtendedFloatingActionButton(
                    onClick = { },
                    modifier = Modifier
                        .width(180.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),

                    ) {
                    Text(text = "CANCEL")
                }


                ExtendedFloatingActionButton(
                    onClick = { },
                    modifier = Modifier
                        .width(180.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),
                ) {
                    Text(text = "SAVE")
                }


            }

        }

    }
}
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun task_list(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){
        item{
            TopAppBar(title = { Text(text = "Task List", color = colorResource(id = R.color.black))})
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
                    Text(text = "Task 1", fontSize = 23.sp, color = Color.DarkGray)
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
                Text(text = "Task 2", fontSize = 23.sp, color = Color.DarkGray)
            }

        }

        item {
            Text(text = "Task summary", modifier = Modifier.padding(start = 10.dp, top = 10.dp), fontSize = 23.sp)
        }


        item {//contenedor de task summary
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, top = 13.dp)
                .height(80.dp)
                .border(
                    BorderStroke(3.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.small //Forma del borde de la fila
                )
            ){

            }

        }


        item{
            Row(modifier = Modifier.padding(start = 10.dp, top = 20.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){

                ExtendedFloatingActionButton(
                    onClick = { },
                    modifier = Modifier
                        .width(180.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),

                    ) {
                    Text(text = "FILTER")
                }


                ExtendedFloatingActionButton(
                    onClick = {  },
                    modifier = Modifier
                        .width(180.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),
                ) {
                    Text(text = "ADD TASK")
                }


            }

        }


    }

}
@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun progress_Group(){

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){
        item{
            TopAppBar(title = { Text(text = "Group", color = colorResource(id = R.color.black))})
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


        item {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp)
            ){
                CircularProgressBar(percentage = 0.5f, number = 100)
            }


        }

        item{
            Row(modifier = Modifier.padding(start = 10.dp, top = 20.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){

                ExtendedFloatingActionButton(
                    onClick = { },
                    modifier = Modifier
                        .padding(vertical = 200.dp)
                        .width(180.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),

                    ) {
                    Text(text = "CANCEL")
                }


                ExtendedFloatingActionButton(
                    onClick = {  },
                    modifier = Modifier
                        .padding(vertical = 200.dp)
                        .width(180.dp)
                        .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),
                ) {
                    Text(text = "DONE")
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

@Preview
@Composable
fun add_user(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan)){

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

        Row(modifier = Modifier.padding(start = 10.dp, top = 20.dp) , horizontalArrangement =  Arrangement.spacedBy(10.dp)){

            ExtendedFloatingActionButton(
                onClick = { },
                modifier = Modifier
                    .width(180.dp)
                    .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),

                ) {
                Text(text = "CANCEL")
            }


            ExtendedFloatingActionButton(
                onClick = {  },
                modifier = Modifier
                    .width(180.dp)
                    .background(Color.Cyan, shape = RoundedCornerShape(8.dp)),
            ) {
                Text(text = "DONE")
            }


        }
    }

}










