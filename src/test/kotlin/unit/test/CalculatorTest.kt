package unit.test

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assumptions.*
import org.opentest4j.TestAbortedException
import unit.test.generator.SimpleDisplayNameGenerator

@DisplayNameGeneration(SimpleDisplayNameGenerator::class)
// @DisplayName("Test for Calculator")
class CalculatorTest {

    companion object {

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("Before all unit test")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("After all unit test")
        }
    }

    private val calculator = Calculator()

    @BeforeEach
    fun beforeEach() {
        println("Before unit test")
    }

    @AfterEach
    fun afterEach() {
        println("After unit test")
    }

    @Test
    // @DisplayName("For CalculatorTest.add 10+10") // untuk merubah display name function
    fun testAddSuccess() {
        println("Unit Test testAddSuccess")
        val result1 = calculator.add(10, 10)
        assertEquals(20, result1, "Value must 20")
    }

    @Test
    // @DisplayName("For CalculatorTest.add 20+10") // untuk merubah display name function
    fun testAddSuccess2() {
        println("Unit Test testAddSuccess2")
        val result2 = calculator.add(20, 10)
        assertEquals(30, result2, "Value must 30")
    }

    @Test
    fun testDivideSuccess() {
        println("Unit Test testDivideSuccess")
        val result = calculator.divide(100, 10)
        assertEquals(10, result)
    }

    @Test
    fun testDivideFailed() {
        println("Unit Test testDivideFailed")
        assertThrows<IllegalArgumentException> {
            calculator.divide(100, 0)
        }
    }

    @Disabled("Pending") // untuk menonaktifkan unit test sementara
    @Test
    fun testComingSoon() {
        // pending
    }

    @Test
    fun testAborted() {
        val profile = System.getenv()["PROFILE"]
        if ("DEV" != profile) {
            throw TestAbortedException()
        }
        println("Test not aborted because Dev Profile")
    }

    @Test
    fun testAssumptions() {
        assumeTrue("DEV" == System.getenv()["PROFILE"])
        println("Test not aborted because Dev Profile")
    }
}