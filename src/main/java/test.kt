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
        assertEquals("1.0" , multiParser("5.0 метр", "5.0 метр", "/"))
        assertEquals("14.4 метр" , multiParser("12.3 метр", "2.1 метр", "+"))
        assertEquals("2.5 метр" , multiParser("16.5 метр", "14.0 метр", "-"))
        assertEquals("25.0 метр^2" , multiParser("5.0 метр", "5.0 метр", "*"))
        assertEquals("16.5 метр > 16.4 метр" , multiParser("16.5 метр", "16.4 метр", "&"))
    }
    @Test
    fun simpleParser() {
        assertEquals("1.0 метр" , simpleParser("5.0 метр", "5.0", "/"))
        assertEquals("24.6 метр" , simpleParser("12.3 метр", "2.0", "*"))
    }

}