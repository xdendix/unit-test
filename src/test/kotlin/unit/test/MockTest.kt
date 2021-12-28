package unit.test

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito

@Suppress("UNCHECKED_CAST")
class MockTest {

    @Test
    fun testMock() {

        val list: List<String> = Mockito.mock(List::class.java) as List<String>

        Mockito.`when`(list[0]).thenReturn("Dendi")
        Mockito.`when`(list[1]).thenReturn("Prayogo")

        assertEquals("Dendi", list[0])
        assertEquals("Dendi", list[0])
        assertEquals("Prayogo", list[1])

        Mockito.verify(list, Mockito.times(2))[0]
        Mockito.verify(list)[1]
    }
}