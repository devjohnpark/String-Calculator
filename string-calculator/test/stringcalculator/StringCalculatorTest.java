package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void add_negative_number() {
        assertThrows(RuntimeException.class, () -> stringCalculator.add("1,-3"));
    }

    @Test
    void add_blank() {
        assertEquals(0, stringCalculator.add(""));
        assertEquals(0, stringCalculator.add(null));
    }

    @Test
    void add_default_separator_singular() {
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void add_comma_separator_multitude() {
        assertEquals(4, stringCalculator.add("1,3"));
        assertEquals(11, stringCalculator.add("1,3,7"));
        assertEquals(1, stringCalculator.add("1,0,0"));
    }

    @Test
    void add_colon_separator_multitude() {
        assertEquals(1, stringCalculator.add("1:0"));
        assertEquals(3, stringCalculator.add("1:2:0"));
    }

    @Test
    void add_comma_or_colon__separator_multitude() {
        assertEquals(15, stringCalculator.add("10,2:3"));
        assertEquals(231, stringCalculator.add("10,221:0"));
        assertEquals(1, stringCalculator.add("1:0,0"));
    }

    @Test
    void add_custom_separator_singular() {
        assertEquals(1, stringCalculator.add("//;\n1"));
        assertEquals(0, stringCalculator.add("//;\n0"));
    }

    @Test
    void add_custom_separator_multitude() {
        assertEquals(6, stringCalculator.add("//|\n1|2|3"));
        assertEquals(3, stringCalculator.add("//|\n0|0|3"));
        assertEquals(13, stringCalculator.add("//$\n10$0$3"));
        assertEquals(243, stringCalculator.add("//$\n10$200$33"));
    }
}