package com.sergio.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergio.views.ui.theme.Black
import com.sergio.views.ui.theme.BlueGray
import kotlin.math.log

@Composable
fun TopSection(){
    //cambia el uicolor dependiendo del modo
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    Box(contentAlignment = Alignment.Center){
        Image(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.46f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = "logo",
            contentScale = ContentScale.FillBounds)

        Row(modifier = Modifier.padding(bottom = 80.dp),
            verticalAlignment = Alignment.CenterVertically){

            Icon(modifier = Modifier.size(42.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColor
            )

            Spacer(modifier = Modifier.width(5.dp))
            Column{
                Text(text = stringResource(id = R.string.Task_man),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor)

                Text(text = stringResource(id = R.string.control),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor)
            }
        }
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor)
    }
}


@Preview
@Composable
fun Loginscreen_2(){
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TopSection()
            Spacer(modifier = Modifier.height(36.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                OutlinedTextField(value = email, onValueChange = {
                    email = it
                }, label = {
                    Text(text = "Email address")
                })
                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text(text = "Password")
                    },
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp) ,
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor =  if (isSystemInDarkTheme()) BlueGray else Black,
                        contentColor = Color.White

                ), shape = RoundedCornerShape(size = 4.dp)
                    ) {
                    Text(text = "Log in", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Forgot Password?")
                }


                Spacer(modifier = Modifier.height(30.dp))
                Column(horizontalAlignment =Alignment.CenterHorizontally) {
                Text(text = "Continue with?", style = MaterialTheme.typography.labelMedium.copy(color=Color(0xFF64748B)))
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    loginSocialmedia(icon = R.drawable.google, text = "google", modifier = Modifier.weight(1f)) {
                        
                    }
                        Spacer(modifier = Modifier.width(20.dp))

                        loginSocialmedia(icon = R.drawable.facebook, text = "facebook", modifier = Modifier.weight(1f)) {

                        }

                    }
                }
            }
        }
    }}

