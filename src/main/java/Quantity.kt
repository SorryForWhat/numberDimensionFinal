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
    fun convertToString():String { return "$x $u"} //Преобразование в строку

    /**
     * Попытка реализации произвольных величин
      */
//    class Unit (){
    // Пример:  14.0 метр + 21.5 километр 1000.0_метр=1км
//        fun setBase(u: String,q: Quantity, r: String) {
//        val newSet = r.split("=")
//        val setB = mutableSetOf<String>("метр, секунд, грамм")
//            return setB.forEach { if (u != q.u) if (newSet.last() == q.u) newSet.first()
//    }
//        }
}

    fun simpleParser(s: String): String {
        val res = s.split(" ") //res[0],res[3] - number; res[1],res[4] - dimension; res[2] - sign
        val unit1 = Quantity(res[0].toDouble(), res[1])
//        if (res.size == 6)
//            res[5].setBase
        if (res.size == 4) {
            if (res[2] == "/") return unit1.rDiv(res[3].toDouble()).convertToString()
            if (res[2] == "*") return unit1.rMul(res[3].toDouble()).convertToString()
        }
        if (res.size == 5) {
            val unit2 = Quantity(res[3].toDouble(), res[4])
            if (res[2] == "/") return unit1.uDiv(unit2).toString()
            if (res[2] == "+") return unit1.uSum(unit2).convertToString()
            if (res[2] == "-") return unit1.uMin(unit2).convertToString()
            if (res[2] == "&") {
                if (res[1] == res[4]) {
                    val comparedUnit1 = unit1.convertToString()
                    val comparedUnit2 = unit2.convertToString()
                    if (res[0].toDouble() > res[3].toDouble()) return "$comparedUnit1 > $comparedUnit2"
                    if (res[0].toDouble() == res[3].toDouble()) return "$comparedUnit1 = $comparedUnit2"
                    if (res[0].toDouble() < res[3].toDouble()) return "$comparedUnit1 < $comparedUnit2"
                } else throw Exception("Unit Mismatch 2")
            }
        } else throw Exception("Invalid Expression Syntax")
    return throw Exception("Invalid Expression Syntax")
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