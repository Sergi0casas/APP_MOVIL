package com.sergio.views.Introduccion

class Reto4 {
}
typealias Plato = Map<String, Any>

class Menu {
    val entradas = mutableListOf<Plato>()
    val platosFuertes = mutableListOf<Plato>()
    val postres = mutableListOf<Plato>()
    val bebidas = mutableListOf<Plato>()

    fun agregarPlato(categoria: String, plato: Plato) {
        when (categoria.toLowerCase()) {
            "entradas" -> entradas.add(plato)
            "platos fuertes" -> platosFuertes.add(plato)
            "postres" -> postres.add(plato)
            "bebidas" -> bebidas.add(plato)
            else -> println("Categoria invalida")
        }
    }

    fun mostrarPlatos() {
        println("------ ENTRADAS ------")
        entradas.forEachIndexed { index, plato ->
            println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} - ${plato["precio"]}")
        }
        println("------ PLATOS FUERTES ------")
        platosFuertes.forEachIndexed { index, plato ->
            println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} - ${plato["precio"]}")
        }
        println("------ POSTRES ------")
        postres.forEachIndexed { index, plato ->
            println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} - ${plato["precio"]}")
        }
        println("------ BEBIDAS ------")
        bebidas.forEachIndexed { index, plato ->
            println("${index + 1}. ${plato["nombre"]} - ${plato["descripcion"]} - ${plato["precio"]}")
        }
    }

    fun mostrarPlatoPorCodigo(categoria: String, codigo: Int) {
        val plato = obtenerPlato(categoria, codigo)
        if (plato != null) {
            println("------ DETALLE DEL PLATO ------")
            println("Nombre: ${plato["nombre"]}")
            println("Descripcion: ${plato["descripcion"]}")
            println("Precio: ${plato["precio"]}")
        } else {
            println("Plato no encontrado.")
        }
    }

    fun modificarPlato(categoria: String, codigo: Int, nuevoPlato: Plato) {
        val plato = obtenerPlato(categoria, codigo)?.toMutableMap()
        if (plato != null) {
            plato["nombre"] = (nuevoPlato["nombre"] ?: plato["nombre"]) as Any
            plato["descripcion"] = (nuevoPlato["descripcion"] ?: plato["descripcion"]) as Any
            plato["precio"] = (nuevoPlato["precio"] ?: plato["precio"]) as Any
            println("Plato modificado exitosamente.")
        } else {
            println("Plato no encontrado.")
        }
    }

    fun eliminarPlato(categoria: String, codigo: Int) {
        val plato = obtenerPlato(categoria, codigo)
        if (plato != null) {
            when (categoria.toLowerCase()) {
                "entradas" -> entradas.remove(plato)
                "platos fuertes" -> platosFuertes.remove(plato)
                "bebidas" -> bebidas.remove(plato)
            }
            println("Plato eliminado exitosamente.")
        } else {
            println("Plato no encontrado.")
        }
    }

    private fun obtenerPlato(categoria: String, codigo: Int): Plato? {
        return when (categoria.toLowerCase()) {
            "entradas" -> if (codigo <= entradas.size) entradas[codigo - 1] else null
            "platos fuertes" -> if (codigo <= platosFuertes.size) platosFuertes[codigo - 1] else null
            "bebidas" -> if (codigo <= bebidas.size) bebidas[codigo - 1] else null
            else -> null
        }
    }
}

fun plato(nombre: String, descripcion: String, precio: Double): Plato {
    return mapOf(
        "nombre" to nombre,
        "descripcion" to descripcion,
        "precio" to precio
    )
}

fun main() {
    val menu = Menu()

    menu.agregarPlato("entradas", plato("Ensalada", "Mezcla de vegetales frescos", 5.0))
    menu.agregarPlato("entradas", plato("Sancocho", "Sopa de sancocho con ingredientes misticos", 4.5))
    menu.agregarPlato("platos fuertes", plato("Pollo", "Pollo entero", 12.0))
    menu.agregarPlato("platos fuertes", plato("Carne", "240 gramos de carne", 10.0))

    menu.mostrarPlatos()

    println("\n--- Modificar Plato ---")
    menu.modificarPlato("platos fuertes", 1, plato("Pollo", "Pollo entero", 14.0))
    menu.mostrarPlatoPorCodigo("platos fuertes", 1)

}