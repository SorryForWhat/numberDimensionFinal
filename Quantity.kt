package src

import java.lang.IllegalArgumentException

/**
 * Possible Signs:
 * "/" - деление
 * "*" - умноженние
 * "+" - сложение
 * "-" - вычитание
 * "&" - сравнение
 */



data class Quantity(val x: Double, val u: String) { //Операции с плавающей точкой
    fun uSum(q: Quantity) = if (u == q.u) Quantity(x + q.x, u) else throw Exception("Unit Mismatch") // Суммирование
    fun uMin(q: Quantity) = if (u == q.u) Quantity(x - q.x, u) else throw Exception("Unit Mismatch") // Вычитание
    fun uMul(q: Quantity) = Quantity(x * q.x, "$u*${q.u}") // Умножение
    fun uDiv(q: Quantity) = Quantity(x / q.x, "$u/${q.u}") //Деление двух величин
    fun rMul(r: Double) = Quantity(x * r, u) // Деление на число
    fun rDiv(r: Double) = Quantity(x / r, u) // Умножение на число
    fun convertToString(): String = "$x $u"





    fun qSum(q1: Quantity, q2: Quantity){
 //       q1.plus(q2)
    }
}
fun readQuantity(s: String): Quantity {
        val res = s.split(" ")
        if (res.size != 2) throw Exception("Invalid Quantity Syntax")
        return Quantity(res[0].toDouble(), res[1])
    }

    fun simpleParser(unit1: Quantity, unit2: String, operation: String): String {
        if (operation == "/") return unit1.rDiv(unit2.toDouble()).convertToString()
        if (operation == "*") return unit1.rMul(unit2.toDouble()).convertToString()
    else throw Exception("Invalid Expression Syntax")
}

fun multiParser(unit1: Quantity, unit2: Quantity, operation: String): String {
    if (operation == "/") {
        return if (unit1.u == unit2.u) unit1.uDiv(unit2).x.toString()
        else unit1.uDiv(unit2).convertToString()
    }
    if (operation == "*") {
        return if (unit1.u == unit2.u) unit1.uMul(unit2).x.toString()+" ${unit1.u}^2"
        else unit1.uMul(unit2).convertToString()
    }
    if (operation == "+") return unit1.uSum(unit2).convertToString()
    if (operation == "-") return unit1.uMin(unit2).convertToString()
    if (operation == "&") if (unit1.u == unit2.u) {
        val comparedUnit1 = unit1.convertToString()
        val comparedUnit2 = unit2.convertToString()
        if (unit1.x > unit2.x) return "$comparedUnit1 > $comparedUnit2"
        if (unit1.x == unit2.x) return "$comparedUnit1 = $comparedUnit2"
        if (unit1.x < unit2.x) return "$comparedUnit1 < $comparedUnit2"
    } else throw Exception("Invalid Expression Syntax")
    else throw Exception("Invalid Expression Syntax")
    throw Exception("Invalid Expression Syntax")
}