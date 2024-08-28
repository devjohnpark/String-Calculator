package stringcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

// 테스트할 경우의 수
// 1. 문자열에서 문자와 숫자가 구분되는지
// 2. 문자열에 '-' 문자가 포함되어 있가면 예외처라가 되는지
// 3. 커스텀 구분자의 문자열 형태인 경우, 문자열 앞부분의 "//;\n"에서 커스텀 구분자 ';'가 추출되는지
// 4. 커스텀 구분자의 의해 "123;321" 에서 123과 321로 분리되는지
// 5. 커스텀 구분자의 문자열 형태가 아닌 경우, 결과값 확인
// 5. 기본 구분자 ','에 의해 "123,321" 에서 123과 321로 분리되는지
// 6. 기본 구분자 ':'에 의해 "123:321" 에서 123과 321로 분리되는지
// 7. 분리된 숫자의 총합이 알맞는지
// 8. 공백 문자열 입력시 0으로 출력되는지

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void calculate_blank() {
        assertEquals(0, stringCalculator.calculate(""));
    }

    @Test
    void calculate_default_separator_singular() {
        assertEquals(1, stringCalculator.calculate("1"));
    }

    @Test
    void calculate_default_separator_multitude() {
        assertEquals(4, stringCalculator.calculate("1,3"));
        assertEquals(11, stringCalculator.calculate("1,3,7"));
        assertEquals(15, stringCalculator.calculate("10,2:3"));
        assertEquals(231, stringCalculator.calculate("10,221:0"));
        assertEquals(1, stringCalculator.calculate("1,0,0"));
        assertEquals(3, stringCalculator.calculate("1:2:0"));
    }

    @Test
    void calculate_custom_separator_singular() {
        assertEquals(1, stringCalculator.calculate("//;\n1"));
        assertEquals(0, stringCalculator.calculate("//;\n0"));
    }

    @Test
    void calculate_custom_separator_multitude() {
        assertEquals(6, stringCalculator.calculate("//|\n1|2|3"));
        assertEquals(3, stringCalculator.calculate("//|\n0|0|3"));
        assertEquals(13, stringCalculator.calculate("//$\n10$0$3"));
        assertEquals(243, stringCalculator.calculate("//$\n10$200$33"));
    }

    @Test
    void calculate_negative_number() {
        assertThrows(RuntimeException.class, () -> stringCalculator.calculate("1,-3"));
    }
}