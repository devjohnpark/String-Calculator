package mystringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 테스트할 경우의 수
// 1. 문자열에서 문자와 숫자가 구분되는지
// 2. 문자열에 '-' 문자가 포함되어 있가면 예외처라가 되는지
// 3. 문자열 앞부분의 "//;\n"에서 커스텀 구분자 ';'가 추출되는지
class CharacterValidatorTest {
    CharacterValidator characterValidator;

    @BeforeEach
    void setUp() {
        characterValidator = new CharacterValidator();
    }

    @Test
    void validCustomSeparator() {
        // Given
        char customSeparator = '|';
        String input = "//" + customSeparator + "\n";
        characterValidator.validCustomSeparator(input);

        // When, Then
        assertTrue(characterValidator.isSeparator(customSeparator));
    }

    @Test
    void isDigit() {
        // Given, When, Then
        assertTrue(characterValidator.isDigit('1'));
        assertTrue(characterValidator.isDigit('0'));
        assertFalse(characterValidator.isDigit('a'));
    }

    @Test
    void isNegativeNumber() {
        // Given, When, Then
        assertFalse(characterValidator.isNegativeNumber('1'));
        assertTrue(characterValidator.isNegativeNumber('-'));
    }

    @Test
    void isSeparator() {
        // Given
        String input = "//12123,31232";
        characterValidator.validCustomSeparator(input);

        // When, Then
        assertTrue(characterValidator.isSeparator(characterValidator.DEFAULT_SEPARATOR1));
        assertTrue(characterValidator.isSeparator(characterValidator.DEFAULT_SEPARATOR2));
    }
}