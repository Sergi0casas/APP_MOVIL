package com.sergio.views.Introduccion


class Reto1(val name: String) {
    var notifications: Int = 0

    fun count_Notifications(count: Int) {
        notifications += count
    }

    fun show_Notification(): String {

        if (notifications == 0) {
            return "No hay mensajes disponibles"
        }

        if (notifications < 100) {
            return "$notifications notificaciones"

        } else {
            return "99+ notificaciones"
        }

    }
}
fun main() {
    val phones = mutableListOf<Reto1>()


    val phone1 = Reto1("Iphone x")
    phone1.count_Notifications(10)
    phones.add(phone1)

    val phone_2 = Reto1("Iphone 11")
    phone_2.count_Notifications(30)
    phones.add(phone_2)
    // muestra las notificaciones recividas
    phones.forEach { phone ->
        println("${phone.name} tiene ${phone.show_Notification()}")
    }
}