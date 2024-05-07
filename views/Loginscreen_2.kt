package com.sergio.views

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.play.integrity.internal.k
import com.sergio.User.MainActivity

import com.sergio.views.navigation.taskScreens
import com.sergio.views.ui.theme.Black
import com.sergio.views.ui.theme.BlueGray
import java.nio.file.attribute.UserDefinedFileAttributeView
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

@Composable
fun UseForm(
    isCreateAccount: Boolean = false, onDone: (String, String)->Unit = {email, pwd->}
){
    val email = rememberSaveable() {
        mutableStateOf("")
    }
    val password = rememberSaveable() {
        mutableStateOf("")
    }
    val passwordVisible = rememberSaveable() {
        mutableStateOf(false)
    }
    val valido = remember(email.value, password.value){
        email.value.trim().isNotEmpty() &&
                password.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        EmailInput(
            emailState = email
        )
        PasswordInput(
            passwordState = password,
            labelId = "Password",
            passwordVisible = passwordVisible
        )
        SubmitButton(
            textId = if (isCreateAccount) "Create account" else "Log in",
            inputValido = valido
        ){
            onDone(email.value.trim(), password.value.trim())
            keyboardController?.hide()
        }
    }

}
@Composable
fun SubmitButton(textId: String, inputValido: Boolean, onClic: ()->Unit){
    Button(onClick = onClic,
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
        containerColor =  if (isSystemInDarkTheme()) BlueGray else Black,
        contentColor = Color.White),
        enabled = inputValido) {
        Text(text = textId,
        modifier = Modifier
            .padding(5.dp))
    }
}

@Composable
fun PasswordInput(
    passwordState: MutableState<String>,
    labelId: String,
    passwordVisible: MutableState<Boolean>
){ val visualTransformation = if(passwordVisible.value)
    VisualTransformation.None
    else PasswordVisualTransformation()
    OutlinedTextField(
        value = passwordState.value,
        onValueChange = {passwordState.value = it},
        label = { Text(text = labelId)} ,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),

        visualTransformation = visualTransformation,
        trailingIcon = {
            if(passwordState.value.isNotBlank()){
                passwordVisibleIcon(passwordVisible)
            }
            else null
        }

    )
}

@Composable
fun passwordVisibleIcon(
    passwordVisible: MutableState<Boolean>
){
    val image =
        if(passwordVisible.value)
            Icons.Default.VisibilityOff
    else
            Icons.Default.Visibility
    IconButton(onClick = {passwordVisible.value  = !passwordVisible.value}){
        Icon(imageVector = image, contentDescription = null)
    }
}

@Composable
fun EmailInput(emailState: MutableState<String>,
               labelId: String="Email"){
    InputField(
        valueState = emailState,
        labelId = labelId,
        keyboardType =KeyboardType.Email

    )
}

@Composable
fun InputField(
    valueState: MutableState<String>,
    labelId: String,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType

){
    OutlinedTextField(
        value = valueState.value,
        onValueChange = {valueState.value = it},
        label = {Text(text = labelId)},
        singleLine = isSingleLine,
        modifier = Modifier
            .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )

    )



}



@Composable
fun Loginscreen_2(navController: NavController,viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){
    val showLoginForm = rememberSaveable() {
        mutableStateOf(true)
    }
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            TopSection()
            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                if(showLoginForm.value){
                    UseForm(
                        isCreateAccount = false
                    ){
                        email, password->
                        Log.d("User", "Loging with $email y $password")
                        viewModel.signInWithEmailAndPassword(email , password ) {
                            navController.navigate(taskScreens.SplashScreen.name)
                        }
                    }
                }
                else{
                    Text(text = "Create an account")
                    UseForm(
                        isCreateAccount = true
                    ){
                            email, password->
                        Log.d("User", "Creating account with $email y $password")
                        viewModel.createUserWithEmailAndPassword(email, password){
                            navController.navigate(taskScreens.metrics.name)
                        }

                    }
                }

                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val text1 =
                        if (showLoginForm.value)"Don't You have an account?"
                    else "You have an account"
                    val text2 =
                        if (showLoginForm.value)"Sign in"
                        else "Log in"
                    Text(text = text1, modifier = Modifier.padding(start = 10.dp),style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
                    Text(text = text2,
                        modifier = Modifier
                            .clickable { showLoginForm.value = !showLoginForm.value }
                            .padding(start = 10.dp),
                        )
                }

                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Forgot Password?",style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
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

