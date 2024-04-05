package com.sergio.views.Introduccion

class Reto3 {
}
class Articulo(val nombre: String, val precioBase: Double)

class Subasta(val articulos: List<Articulo>) {
    val ofertas: MutableMap<Articulo, Double> = mutableMapOf()

    fun realizarOferta(articulo: Articulo, precioOferta: Double) {
        if (precioOferta > articulo.precioBase) {
            ofertas[articulo] = precioOferta
        } else {
            println("La oferta debe ser mayor que el precio base.")
        }
    }

    fun venderArticulos() {
        for (articulo in articulos) {
            val oferta = ofertas[articulo]
            if (oferta != null) {
                println("El artículo '${articulo.nombre}' se vendió por $${oferta}.")
            } else {
                println("No hubo ofertas por el artículo '${articulo.nombre}'. Se vende a la casa de subastas por el precio base de $${articulo.precioBase}.")
            }
        }
    }
}

fun main() {
    val pintura = Articulo("Pintura", 100.0)
    val acrilico = Articulo("Acrilico", 200.0)
    val art_mist = Articulo("Artefacto misterioso", 115.0)


    val articulos = listOf(pintura, acrilico, art_mist)

    val subasta = Subasta(articulos)

    subasta.realizarOferta(pintura, 150.0)
    subasta.realizarOferta(art_mist, 250.0)

    subasta.venderArticulos()
}
