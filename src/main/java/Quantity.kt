package src
/**
 * Possible Signs:
 * "/" - деление
 * "*" - умноженние
 * "+" - сложение
 * "-" - вычитание
 * "&" - сравнение
*/
data class Quantity(val x: Double, val u: String) {
    fun uSum(q: Quantity) = if (u == q.u) Quantity(x + q.x, u) else throw Exception("Unit Mismatch")
    fun uMin(q: Quantity) = if (u == q.u) Quantity(x - q.x, u) else throw Exception("Unit Mismatch")
    fun uDiv(q: Quantity) = if (u == q.u) x / q.x else throw Exception("Unit Mismatch")
    fun rMul(r: Double) = Quantity(x * r, u)
    fun rDiv(r: Double) = Quantity(x / r, u)
}
    fun simpleParser(s: String): String {
        val res = s.split(" ") //res[0],res[3] - number; res[1],res[4] - dimension; res[2] - sign
        val unit1 = Quantity(res[0].toDouble(), res[1])
        if (res.size == 4) {
            if (res[2] == "/") return unit1.rDiv(res[3].toDouble()).toString()
            if (res[2] == "*") return unit1.rMul(res[3].toDouble()).toString()
        }
        if (res.size == 5) {
            val unit2 = Quantity(res[3].toDouble(), res[4])
            if (res[2] == "/") return unit1.uDiv(unit2).toString()
            if (res[2] == "+") return unit1.uSum(unit2).toString()
            if (res[2] == "-") return unit1.uMin(unit2).toString()
            if (res[2] == "&") {
                if (res[1] == res[4]) {
                    if (res[0].toDouble() > res[3].toDouble()) return "$unit1 > $unit2"
                    if (res[0].toDouble() == res[3].toDouble()) return "$unit1 = $unit2"
                    if (res[0].toDouble() < res[3].toDouble()) return "$unit1 < $unit2"
                } else throw Exception("Unit Mismatch 2")
            }
        } else throw Exception("Invalid Expression Syntax")
    return ""
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
//    fun maid (args: Array<String>) {
//        if (!args.toString().matches(Regex("""\d+\.\d+\s+[a-zA-z]+\s+[\+\-\*\/\и]\s+\d+\.\d+\s+[a-zA-z]*"""))) println( "123")
//        for (i in args.toString().split(" "))
//            println(args)
//    }
    return
}