/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

data class User(var nombre : String, var apellido : String = "", var edad: Int = 0, var esAlto: Boolean = false)
data class Transaccion(var categoria : String, var monto : Double)

fun Int.esPar(): Boolean {
    return (this % 2 == 0)
}

fun main() {

    // a) extender la clase Int
    
    val a : Int = 0
    println("el numero $a es par: " + a.esPar())
    val b : Int = 1
    println("el numero $b es par: " + b.esPar())
    val c : Int = 2
    println("el numero $c es par: " + c.esPar())
    
    // b) apply
    
    val usuario : User = User(nombre = "pepe").apply {
        apellido = "perez"
        edad = 25
        esAlto = false
    }
    
    println(usuario)
    
    // filter y map
	var lista = listOf(1, 2, 3, 5, 6, 11, 12, 21, 30, 40)
    var nuevaLista = (lista.filter { it % 3 == 0}).map {it * it}
    
    println(nuevaLista)
    
    // filter, groupBy, mapValues
    var transaccion1 : Transaccion = Transaccion(categoria = "A", monto = 1500.95)
    var transaccion2 : Transaccion = Transaccion(categoria = "B", monto = 179.99)
    var transaccion3 : Transaccion = Transaccion(categoria = "B", monto = 500.99)
    var transaccion4 : Transaccion = Transaccion(categoria = "A", monto = 58.01)
    var transaccion5 : Transaccion = Transaccion(categoria = "C", monto = 250.65)
    
    var transacciones = listOf(transaccion1, transaccion2, transaccion3, transaccion4, transaccion5)
    val transaccionesFiltradas = ((transacciones.filter { it.monto > 100 }).groupBy { it.categoria }).mapValues { (categoria, transacciones) -> transacciones.map {it.monto}.average() }
    
    print(transaccionesFiltradas)
    
}
