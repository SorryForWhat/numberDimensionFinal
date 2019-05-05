package src

import org.junit.Test
import org.junit.Assert.*

class Tests {
    @Test
    fun readQuantity(){
        assertEquals(Quantity(12.0, "секунд"), readQuantity ("12 секунд"))
        assertEquals(Quantity(12.4, "метр"), readQuantity ("12.4 метр"))
    }
    @Test
    fun multiParser() {
        assertEquals("2.44" , multiParser(readQuantity("12.2 метр"), readQuantity("5.0 метр"), "/"))
        assertEquals("25.0 метр^2" , multiParser(readQuantity("5.0 метр"), readQuantity("5.0 метр"), "*"))
        assertEquals("12.0 метр" , multiParser(readQuantity("5.3 метр"), readQuantity("6.7 метр"), "+"))
        assertEquals("13.5 метр" , multiParser(readQuantity("19.0 метр"), readQuantity("5.5 метр"), "-"))
        assertEquals("5.0 метр = 5.0 метр" , multiParser(readQuantity("5.0 метр"), readQuantity("5.0 метр"), "&"))
        assertEquals("5.0 метр < 5.1 метр" , multiParser(readQuantity("5.0 метр"), readQuantity("5.1 метр"), "&"))
        assertEquals("5.1 метр > 4.9 метр" , multiParser(readQuantity("5.1 метр"), readQuantity("4.9 метр"), "&"))
    }
    @Test
    fun simpleParser() {
        assertEquals("1.0 метр" , simpleParser(readQuantity("5.0 метр"), "5.0", "/"))
        assertEquals("24.6 метр" , simpleParser(readQuantity("12.3 метр"), "2.0", "*"))
    }

}