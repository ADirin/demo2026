import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Unit Tests")
class CalTest {

    private static final double DELTA = 0.0001; // Tolerance for floating-point comparisons

    // ==================== Addition Tests ====================

    @Test
    @DisplayName("addMe: positive + positive")
    void testAddPositiveNumbers() {
        assertEquals(5.0, Cal.addMe(2.0, 3.0), DELTA);
    }

    @Test
    @DisplayName("addMe: negative + negative")
    void testAddNegativeNumbers() {
        assertEquals(-5.0, Cal.addMe(-2.0, -3.0), DELTA);
    }

    @Test
    @DisplayName("addMe: positive + negative")
    void testAddMixedSigns() {
        assertEquals(1.0, Cal.addMe(3.0, -2.0), DELTA);
    }

    @Test
    @DisplayName("addMe: with zero")
    void testAddWithZero() {
        assertEquals(5.0, Cal.addMe(5.0, 0.0), DELTA);
        assertEquals(5.0, Cal.addMe(0.0, 5.0), DELTA);
    }

    @Test
    @DisplayName("addMe: with decimals")
    void testAddDecimals() {
        assertEquals(0.3, Cal.addMe(0.1, 0.2), DELTA);
    }

    // ==================== Subtraction Tests ====================

    @Test
    @DisplayName("subMe: positive - positive (larger result)")
    void testSubPositiveNumbers() {
        assertEquals(3.0, Cal.subMe(5.0, 2.0), DELTA);
    }

    @Test
    @DisplayName("subMe: positive - positive (negative result)")
    void testSubResultNegative() {
        assertEquals(-3.0, Cal.subMe(2.0, 5.0), DELTA);
    }

    @Test
    @DisplayName("subMe: negative numbers")
    void testSubNegativeNumbers() {
        assertEquals(1.0, Cal.subMe(-2.0, -3.0), DELTA);
    }

    @Test
    @DisplayName("subMe: subtract zero")
    void testSubZero() {
        assertEquals(5.0, Cal.subMe(5.0, 0.0), DELTA);
    }

    @Test
    @DisplayName("subMe: same numbers gives zero")
    void testSubSameNumbers() {
        assertEquals(0.0, Cal.subMe(5.0, 5.0), DELTA);
    }

    // ==================== Multiplication Tests ====================

    @Test
    @DisplayName("mulMe: positive * positive")
    void testMulPositiveNumbers() {
        assertEquals(6.0, Cal.mulMe(2.0, 3.0), DELTA);
    }

    @Test
    @DisplayName("mulMe: negative * negative gives positive")
    void testMulTwoNegatives() {
        assertEquals(6.0, Cal.mulMe(-2.0, -3.0), DELTA);
    }

    @Test
    @DisplayName("mulMe: positive * negative gives negative")
    void testMulMixedSigns() {
        assertEquals(-6.0, Cal.mulMe(2.0, -3.0), DELTA);
    }

    @Test
    @DisplayName("mulMe: multiply by zero")
    void testMulByZero() {
        assertEquals(0.0, Cal.mulMe(5.0, 0.0), DELTA);
    }

    @Test
    @DisplayName("mulMe: multiply by one")
    void testMulByOne() {
        assertEquals(5.0, Cal.mulMe(5.0, 1.0), DELTA);
    }

    // ==================== Division Tests ====================

    @Test
    @DisplayName("divMe: positive / positive")
    void testDivPositiveNumbers() {
        assertEquals(2.0, Cal.divMe(6.0, 3.0), DELTA);
    }

    @Test
    @DisplayName("divMe: negative / positive")
    void testDivMixedSigns() {
        assertEquals(-2.0, Cal.divMe(-6.0, 3.0), DELTA);
    }

    @Test
    @DisplayName("divMe: negative / negative gives positive")
    void testDivTwoNegatives() {
        assertEquals(2.0, Cal.divMe(-6.0, -3.0), DELTA);
    }

    @Test
    @DisplayName("divMe: divide by zero returns 0")
    void testDivByZero() {
        assertEquals(0.0, Cal.divMe(6.0, 0.0), DELTA);
    }

    @Test
    @DisplayName("divMe: zero divided by zero returns 0")
    void testZeroDivByZero() {
        assertEquals(0.0, Cal.divMe(0.0, 0.0), DELTA);
    }

    @Test
    @DisplayName("divMe: zero divided by non-zero")
    void testZeroDivByNumber() {
        assertEquals(0.0, Cal.divMe(0.0, 5.0), DELTA);
    }

    // ==================== Parameterized Tests ====================

    @ParameterizedTest(name = "addMe({0}, {1}) = {2}")
    @CsvSource({
            "1, 2, 3",
            "0, 0, 0",
            "-1, -1, -2",
            "10, -5, 5",
            "2.5, 2.5, 5.0"
    })
    void testAddParameterized(double a, double b, double expected) {
        assertEquals(expected, Cal.addMe(a, b), DELTA);
    }

    @ParameterizedTest(name = "subMe({0}, {1}) = {2}")
    @CsvSource({
            "5, 3, 2",
            "0, 0, 0",
            "3, 5, -2",
            "-5, -3, -2",
            "10.5, 0.5, 10.0"
    })
    void testSubParameterized(double a, double b, double expected) {
        assertEquals(expected, Cal.subMe(a, b), DELTA);
    }

    @ParameterizedTest(name = "mulMe({0}, {1}) = {2}")
    @CsvSource({
            "2, 3, 6",
            "0, 5, 0",
            "-2, 3, -6",
            "-2, -3, 6",
            "2.5, 4, 10.0"
    })
    void testMulParameterized(double a, double b, double expected) {
        assertEquals(expected, Cal.mulMe(a, b), DELTA);
    }

    @ParameterizedTest(name = "divMe({0}, {1}) = {2}")
    @CsvSource({
            "6, 3, 2",
            "0, 5, 0",
            "-6, 3, -2",
            "-6, -3, 2",
            "1, 0, 0",   // div by zero returns 0
            "10.0, 4.0, 2.5"
    })
    void testDivParameterized(double a, double b, double expected) {
        assertEquals(expected, Cal.divMe(a, b), DELTA);
    }
}