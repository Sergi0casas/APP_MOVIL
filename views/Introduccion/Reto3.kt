package com.sergio.views.Introduccion

class Reto3 {
}
//paramteros nombre y precio que va a dar
class Articulo(val nombre: String, val precio: Double)

class Subasta(val articulos: List<Articulo>) {
    //se utiliza un hashmap que tiene que ser mutable para ir modificandolo
    //sus parametros van a ser la clase arituclo y un precio que es un double
    val ofertas: MutableMap<Articulo, Double> = mutableMapOf()

    fun Oferta(articulo: Articulo, pOferta: Double) {

        if (pOferta > articulo.precio) {
            ofertas[articulo] = pOferta
        } else {
            println("La oferta debe ser mayor")
        }
    }

    fun venderArticulos() {
        for (articulo in articulos) {
            val oferta = ofertas[articulo]
            if (oferta != null) {
                println("El artículo '${articulo.nombre}' se vendió por $${oferta}.")
            } else {
                println("No hubo ofertas por el artículo '${articulo.nombre}'. Se vende a vernder por el precio base $${articulo.precio}.")
            }
        }
    }
}

fun main() {
    val pintura = Articulo("Pintura", 100089.00)
    val acrilico = Articulo("Acrilico", 800989.89)
    val art_mist = Articulo("Artefacto misterioso", 19900908766177777777777777775.99)

//listof crea una lista
    val articulos = listOf(pintura, acrilico, art_mist)

    val subasta = Subasta(articulos)

    subasta.Oferta(pintura, 150.0)
    subasta.Oferta(art_mist, 250.0)

    subasta.venderArticulos()
}
