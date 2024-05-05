import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.views.R

@Preview
@Composable
fun loginScreen(){
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    Surface(modifier = Modifier.fillMaxSize()) {


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Company logo sergio",
                modifier = Modifier.size(200.dp)
            )
            Text(text = "Welcome", fontSize = 28.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Login to your account")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(value = email, onValueChange = {
                email = it
            }, label = {
                Text(text = "Email address")
            })
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = {
                    Text(text = "Password")
                },
                visualTransformation = PasswordVisualTransformation()
            )//this doesn't show the password

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                Log.i("Credential", "Email:$email Password: $password")
            }) {
                Text(text = "Login")

            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Forgot Password?")
            }


        }
    }
}