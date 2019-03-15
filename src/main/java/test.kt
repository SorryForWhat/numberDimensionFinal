package src

import org.junit.Test
import org.junit.Assert.*

class Tests {
    @Test
    fun simpleParser() {
//        assertEquals("70.0 метр" , simpleParser("28.0 метр * 2.5"))
//        assertEquals("2.0 метр" , simpleParser("28.0 метр / 14.0 "))
//        assertEquals("42.0 метр" , simpleParser("28.0 метр + 14.0 метр"))
//        assertEquals("14.0 метр" , simpleParser("28.0 метр - 14.0 метр"))
        assertEquals("2.0" , simpleParser("28.0 метр / 14.0 метр"))
        assertEquals("2.0" , simpleParser("28.0 метр & 14.0 метр"))

    }

}