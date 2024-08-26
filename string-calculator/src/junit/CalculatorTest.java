package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// It can execute each test method so don't affect other method
// It can automatically check result value of method execution.
class CalculatorTest {

    @Test
    void add() {
        Calculator calc = new Calculator();
        assertEquals(3, calc.add(1, 2)); // expected value, actual value
    }

    @Test
    void subtract() {
        Calculator calc = new Calculator();
        assertEquals(-1, calc.subtract(1, 2));
    }

    @Test
    void multiply() {
        Calculator calc = new Calculator();
        assertEquals(4, calc.multiply(2, 2));
    }

    @Test
    void divide() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.divide(2, 2));
    }
}