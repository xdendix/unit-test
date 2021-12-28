package unit.test

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.condition.*

class ConditionalTest {

    @Test
    @EnabledOnOs(value = [OS.WINDOWS, OS.LINUX])
    fun enabledOnWindowsOrLinux() {
        // only run on Windows or Linux
    }

    @Test
    @DisabledOnOs(value = [OS.WINDOWS])
    fun disabledOnWindows() {
        // can't run on Windows
    }

    @Test
    @EnabledOnJre(value = [JRE.JAVA_17])
    fun onlyRunOnJava17() {
        // only run on Java 17
    }

    @Test
    @DisabledOnJre(value = [JRE.JAVA_17])
    fun disabledRunOnJava17() {
        // disabled run on Java 17
    }

    @Test
    fun printSystemProperties() {
        System.getProperties().forEach { key, value ->
            println("$key => $value")
        }
    }

    @Test
    @EnabledIfSystemProperties(
        value = [
            EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
        ]
    )
    fun enabledOnOracle() {

    }

    @Test
    @DisabledIfSystemProperties(
        value = [
            DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
        ]
    )
    fun disabledOnOracle() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun enabledOnDev() {

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun disabledOnDev() {

    }
}