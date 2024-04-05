package com.sergio.views.Introduccion


class Reto1(val name: String) {
    var notifications: Int = 0

    fun receiveNotifications(count: Int) {
        notifications += count
    }

    fun getNotificationSummary(): String {
        return when {
            notifications == 0 -> "No hay mensajes disponibles"
            notifications < 100 -> "$notifications notificaciones"
            else -> "99+ notificaciones"
        }
    }
}
fun main() {
    val phones = mutableListOf<Reto1>()


    val phone1 = Reto1("Iphone 1")
    phone1.receiveNotifications(10)
    phones.add(phone1)

    val phone_2 = Reto1("Iphone 2")
    phone_2.receiveNotifications(30)
    phones.add(phone_2)
    // Mostrar el resumen de notificaciones para cada teléfono
    phones.forEach { phone ->
        println("${phone.name} tiene ${phone.getNotificationSummary()}")
    }
}