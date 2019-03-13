package src

import org.junit.Test
import org.junit.Assert.*

class test {
    @Test
    fun check() {
    assertEquals(listOf(""), check(Quantity(10.0, "метры"),
        Quantity(14.0, "метры")))
}
}