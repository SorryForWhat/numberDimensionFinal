package src


import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows
import java.lang.Exception
import java.lang.IllegalArgumentException


class Tests {
    val num1 = Quantity.readQuantity("12.2 метр")
    val num2 = Quantity.readQuantity("5 секунд")
    val num3 = Quantity.readQuantity("5.0 метр")
    val num4 = Quantity.readQuantity("6.7 метр")
    val num5 = Quantity.readQuantity("5.3 метр")
    val num6 = Quantity.readQuantity("12 секунд")
    val num7 = Quantity.readQuantity("12.5 метр")

    @Test
    fun readQuantity(){
        assertEquals(Quantity(12.0, "секунд"), num6)
        assertEquals(Quantity(12.5, "метр"), num7)
    }
    @Test
    fun multiParser() {
        assertEquals("2.44 метр/секунд" , multiParser(num1 , num2, "/"))
        assertEquals("2.44" , multiParser(num1, num3, "/"))
        assertEquals("25.0 метр^2" , multiParser(num3, num3, "*"))
        assertEquals("12.0 метр" , multiParser(num4, num5, "+"))
        assertEquals("7.5 метр" , multiParser(num7, num3, "-"))
        assertEquals("12.2 метр > 5.0 метр" , multiParser(num1, num3, "&"))
        assertEquals("5.0 метр = 5.0 метр" , multiParser(num3, num3, "&"))
    }
    @Test
    fun simpleParser() {
        assertEquals("1.0 метр" , simpleParser(num3, 5.0, "/"))
        assertEquals("24.4 метр" , simpleParser(num1, 2.0, "*"))
    }

}