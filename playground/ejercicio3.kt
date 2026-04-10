/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    
	var montosTransaccionales : Array<Int?> = arrayOf(100, 200, null, 400, null)
    var montoTotal : Int = 0
    
  	montoTotal = sumarMontos(montosTransaccionales)
    
    println("monto total: $montoTotal")
}

fun sumarMontos(montosTransaccionales : Array<Int?>): Int {
    
    var montoTotal : Int = 0
    
    for (monto in montosTransaccionales) {
        println(monto)
        var valor: Int = monto ?: 0;
        montoTotal += valor;
    }
    
    return montoTotal
}
