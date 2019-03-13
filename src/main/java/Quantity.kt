package src
data class Quantity(val x: Double, val u: String) {
    fun uSum(q: Quantity) = if (u == q.u) Quantity(x + q.x, u) else throw Exception("Unit Mismatch")
    fun uMin(q: Quantity) = if (u == q.u) Quantity(x - q.x, u) else throw Exception("Unit Mismatch")
    fun uDiv(q: Quantity) = if (u == q.u) x / q.x else throw Exception("Unit Mismatch")
    fun rMul(r: Double) =  Quantity(x * r, u)
    fun rDiv(r: Double) =  Quantity(x / r, u)
}

fun check(a: Quantity, b: Quantity):List<Any> {
    val z1 = a.uSum(b)
    val z2 = a.uMin(b)
    val z3 = a.rDiv(3.0)
    val z4 = a.rMul(3.0)
    val z5 = a.uDiv(b)
    return listOf(z1,z2,z3,z4,z5)
}

fun main(args: Array<String>){
    println()
}