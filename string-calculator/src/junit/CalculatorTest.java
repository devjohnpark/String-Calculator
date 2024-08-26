package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// It can execute each test method so don't affect other method
// It can automatically check result value of method execution.
class CalculatorTest {

    // Remove duplicate code
    private Calculator calc;

    @BeforeEach
    public void setUp() {
        calc = new Calculator();
        System.out.println("Test setup");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test closed");
    }

    @Test
    void add() {
        assertEquals(3, calc.add(1, 2)); // expected value, actual value
    }

    @Test
    void subtract() {
        assertEquals(-1, calc.subtract(1, 2));
    }

    @Test
    void multiply() {
        assertEquals(4, calc.multiply(2, 2));
    }

    @Test
    void divide() {
        assertEquals(1, calc.divide(2, 2));
    }
}