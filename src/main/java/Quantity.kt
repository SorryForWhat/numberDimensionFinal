package src

/**
 * Possible Signs:
 * "/" - деление
 * "*" - умноженние
 * "+" - сложение
 * "-" - вычитание
 * "&" - сравнение
 */



data class Quantity(val x: Double, val u: String)  { //Операции с плавающей точкой
    fun convertToString(): String = "$x $u"
    operator fun plus(q: Quantity) = if (u == q.u) Quantity(x + q.x, u).convertToString() else throw Exception("Unit Mismatch") // Суммирование
    operator fun minus(q: Quantity) = if (u == q.u) Quantity(x - q.x, u).convertToString() else throw Exception("Unit Mismatch") // Вычитание
    operator fun times(q: Quantity) = Quantity(x * q.x, "$u*${q.u}") // Умножение
    operator fun div(q: Quantity) = Quantity(x / q.x, "$u/${q.u}") //Деление двух величин
    operator fun times(r: Double) = Quantity(x * r, u).convertToString() // Деление на число
    operator fun div(r: Double) = Quantity(x / r, u).convertToString() // Умножение на число
    companion object {fun readQuantity(s: String): Quantity {
            val res = s.split(" ")
            if (res.size != 2) throw Exception("Invalid Quantity Syntax")
            return Quantity(res[0].toDouble(), res[1])
        }
        }
    }


    fun simpleParser(unit1: Quantity, unit2: Double, operation: String): String {
        if (operation == "/") return unit1/unit2
        if (operation == "*") return unit1*unit2
    else throw Exception("Invalid Expression Syntax")
}

fun multiParser(unit1: Quantity, unit2: Quantity, operation: String): String {
    if (operation == "/") {
        return if (unit1.u == unit2.u) unit1.div(unit2).x.toString()
        else unit1.div(unit2).convertToString()
    }
    if (operation == "*") {
        return if (unit1.u == unit2.u) unit1.times(unit2).x.toString()+" ${unit1.u}^2"
        else unit1.times(unit2).convertToString()
    }
    if (operation == "+") return unit1.plus(unit2)
    if (operation == "-") return unit1.minus(unit2)
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