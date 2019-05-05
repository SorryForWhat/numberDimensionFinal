package src
/**
 * Possible Signs:
 * "/" - деление
 * "*" - умноженние
 * "+" - сложение
 * "-" - вычитание
 * "&" - сравнение
*/



data class Quantity(val x: Double, val u: String) { //Операции с плавающей точкой

    fun uSum(q: Quantity) = if (u == q.u) Quantity(x + q.x, u) else throw Exception("Unit Mismatch") //Суммирование
    fun uMin(q: Quantity) = if (u == q.u) Quantity(x - q.x, u) else throw Exception("Unit Mismatch") //Вычитание
    fun uDiv(q: Quantity) = if (u == q.u) x / q.x else throw Exception("Unit Mismatch") // Деление двух величин
    fun rMul(r: Double) = Quantity(x * r, u) // Деление на число
    fun rDiv(r: Double) = Quantity(x / r, u) // Умножение на число
    fun uMul(q: Quantity) = if (u == q.u) Quantity(x * q.x, u) else throw Exception("Unit Mismatch") //Вычитание
    fun convertToString():String { return "$x $u"} //Преобразование в строку


}
    fun readQuantity (s: String): Quantity {
        val res = s.split(" ")
        return Quantity(res[0].toDouble(), res[1])
    }

    fun simpleParser(unitQ1: String, unitQ2: String, operation: String): String {
        val unit1 = readQuantity(unitQ1)
            if (operation == "/") return unit1.rDiv(unitQ2.toDouble()).convertToString()
            if (operation == "*") return unit1.rMul(unitQ2.toDouble()).convertToString()
        else throw Exception("Invalid Expression Syntax")
        }
    fun multiParser(unitQ1: String, unitQ2: String, operation: String): String {
        val unit1 = readQuantity(unitQ1)
        val unit2 = readQuantity(unitQ2)
        if (operation == "/") return unit1.uDiv(unit2).toString()
        if (operation == "+") return unit1.uSum(unit2).convertToString()
        if (operation == "-") return unit1.uMin(unit2).convertToString()
        if (operation == "&") if (unit1.u == unit2.u) {
            val comparedUnit1 = unit1.convertToString()
            val comparedUnit2 = unit2.convertToString()
            if (unit1.x > unit2.x) return "$comparedUnit1 > $comparedUnit2"
            if (unit1.x == unit2.x) return "$comparedUnit1 = $comparedUnit2"
            if (unit1.x < unit2.x) return "$comparedUnit1 < $comparedUnit2"
        } else throw Exception("Invalid Expression Syntax")
        if (operation == "*") return unit1.uMul(unit2).convertToString() + "^2"
        else throw Exception("Invalid Expression Syntax")
    }