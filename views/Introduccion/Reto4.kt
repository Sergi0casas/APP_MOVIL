package com.sergio.views.Introduccion

class Reto4 {
}
//se crea una alias de palto que es un map que recive dos parametros primero un string y el otro culaquiera
typealias Plato = Map<String, Any>

class Menu {
    val entradas = mutableListOf<Plato>()
    val platosFuertes = mutableListOf<Plato>()
    val bebidas = mutableListOf<Plato>()

    fun agregarPlato(categoria: String, plato: Plato) {
        //lowercase nos conviete la categoria en todos minusculas
        when (categoria.toLowerCase()) {
            //si categoria es igual a entrada entonces agrega el plato
            "entradas" -> entradas.add(plato)
            //Si es igual a platos fuertes lo agrega
            "platos fuertes" -> platosFuertes.add(plato)
            "bebidas" -> bebidas.add(plato)
            else -> println("Categoria no existente")
        }
    }

    fun mostrarPlatos() {
        println("ENTRADAS")
        //Recorre las entradas por indice en hashmap y muestra la entrada
        entradas.forEachIndexed { index, plato ->
            println("${index + 1}. ${plato["nombre"]} // ${plato["descripcion"]} // ${plato["precio"]}")
        }
        println("PLATOS FUERTES")
        platosFuertes.forEachIndexed { index, plato ->
            println("${index + 1}. ${plato["nombre"]} // ${plato["descripcion"]} // ${plato["precio"]}")
        }
        println("BEBIDAS")
        bebidas.forEachIndexed { index, plato ->
            println("${index + 1}. ${plato["nombre"]} // ${plato["descripcion"]} // ${plato["precio"]}")
        }
    }

    fun mostrarPlatoPorCodigo(categoria: String, codigo: Int) {
        val plato = get_plato(categoria, codigo)
        if (plato != null) {
            println("DESCRIPTION DEL PLATO")
            println("Nombre : ${plato["nombre"]}")
            println("Descripcion : ${plato["descripcion"]}")
            println("Precio : ${plato["precio"]}")
        } else {
            println("El plato no existe o no se pudo encontrar")
        }
    }

    fun modificarPlato(categoria: String, codigo: Int, nuevoPlato: Plato) {
        //plato se vuelve un mutablemap
        val plato = get_plato(categoria, codigo)?.toMutableMap()
        //si el plato existe entonces se modifican cada uno de los atributos
        if (plato != null) {
            //siendo la lllave el nombre y el valor el nuevo nombre
            plato["nombre"] = (nuevoPlato["nombre"] ?: plato["nombre"]) as Any
            //siendo la llave la descripcion y el valor sera la nueva descripcion
            plato["descripcion"] = (nuevoPlato["descripcion"] ?: plato["descripcion"]) as Any
            plato["precio"] = (nuevoPlato["precio"] ?: plato["precio"]) as Any
            println("Plato modificado exitosamente.")
        } else {
            println("Plato no encontrado.")
        }
    }

    fun delete_Plato(categoria: String, codigo: Int) {
        val plato = get_plato(categoria, codigo)
        //si el plato existe lo eliminamos con el metodo remove
        //primero se pasa a minusculas pa poderlo eliminar
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
//se obtiene cada plato para utilizarlo en los metodos
    private fun get_plato(categoria: String, codigo: Int): Plato? {
        return when (categoria.toLowerCase()) {
            //si el codigo proporcionado es mayor que el tamaño de la lista correspondiente la funcion también devuelve null esto se hace pa evitar errores de índice fuera de rango.
            "entradas" -> if (codigo <= entradas.size) entradas[codigo - 1] else null
            "platos fuertes" -> if (codigo <= platosFuertes.size) platosFuertes[codigo - 1] else null
            "bebidas" -> if (codigo <= bebidas.size) bebidas[codigo - 1] else null
            else -> null
        }
    }
}

fun plato(nombre: String, descripcion: String, precio: Double): Plato {
    //crea un map de el nombre , la descripcion y el precio
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

    println("\nModificar plato")
    menu.modificarPlato("platos fuertes", 1, plato("Pollo", "Pollo entero", 14.0))
    menu.mostrarPlatoPorCodigo("platos fuertes", 1)

}