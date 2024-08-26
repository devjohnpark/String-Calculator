package stringcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    void calculate() {
        assertEquals(6, stringCalculator.calculate("//;\n1;2;3"));
        assertEquals(4, stringCalculator.calculate("1,3"));
        assertEquals(15, stringCalculator.calculate("10,2:3"));
        assertEquals(231, stringCalculator.calculate("10,221:0"));
        assertEquals(0, stringCalculator.calculate(""));
        assertEquals(1, stringCalculator.calculate("1,0,0"));
        assertThrows(RuntimeException.class, () -> stringCalculator.calculate("1,-3"));
    }

    @Test
    void getSeparator() {
//        String pre = "//";
//        String post = "\n";
        char expectedSeparator = ';';
//        String input = "//"
        assertEquals(expectedSeparator, stringCalculator.getSeparator("//;\n1;2;3"));
    }

    @Test
    void isCustomSeparator() {
        String pre = "//";
        String post = "\n";
        char expectedSeparator = ';';
        String input = pre + expectedSeparator + post;
        assertEquals(true, stringCalculator.isCustomSeparator(input, pre, post));
    }

    @Test
    void addNumber() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(2);
        queue.add(3);
        assertEquals(323, stringCalculator.addNumber(queue));
    }
}