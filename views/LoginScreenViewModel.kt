package com.sergio.views

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.sergio.views.model.User
import kotlinx.coroutines.launch
import java.lang.Exception


class LoginScreenViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    //esto impide que se creen varios usuarios a la vez
    private val _loading = MutableLiveData(false)
    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("Login completed", "signInWithEmailAndPassword")
                            // Aquí puedes llamar a la función home si el inicio de sesión fue exitoso
                            home()
                        } else {
                            Log.d(
                                "Login completed",
                                "signInWithEmailAndPassword:${task.result.toString()}"
                            )
                        }
                    }
            } catch (ex: Exception) {
                Log.d("Login completed", "signInWithEmailAndPassword: ${ex.message}")
            }
        }

    fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        home: () -> Unit
    ){
        if(_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener{ task->
                    if(task.isSuccessful){
                        val displayName =
                            task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        home()
                    }
                    else{
                        Log.d("User", "createWithEmailAndPassword:${task.result.toString()}")
                    }
                    _loading.value = false
                }
        }



    }
    private fun createUser(displayName: String?){
        val userId = auth.currentUser?.uid
     //   val user = mutableMapOf<String, Any>()
    //    user["user_id"] = userId.toString()
    //    user["display_name"] = displayName.toString()
        val user = User(
            userId = userId.toString(),
            displayName = displayName.toString(),
            avatarUrl = "",
            quote = "Lo dificil ya paso",
            profession = "Programmer",
            id = null

        ).toMap()
        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("User", "Created${it.id}")
            }.addOnFailureListener{
                Log.d("User", "error ${it}")
            }
    }


}
