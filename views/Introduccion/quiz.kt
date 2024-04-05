package com.sergio.views.Introduccion

class quiz {
}

fun hola(name:String?){
    println("Hola " + name)
}


fun calculadora(a:Int, b:Int){

    println("Ingrese que operacion desea realizar: \n1.Suma\n2.Resta\n3.Multiplicacion")
    val oper = readLine()!!.toInt()

    if( oper == 0){
        println(a+b)
    }
    if(oper == 1){
        println(a-b)
    }
    if(oper == 2){
        println(a*b)
    }
}

fun main(){
    //las funciones necesitan parametros cuando el usuario necesita algo
    hola("Sergio")
    calculadora(3,4)
}