package stringcalculator;

import java.util.Optional;

// 구분자와 숫자 유효성을 확인하는 클래스
class SeparatorValidator {

    private static final char DEFAULT_SEPARATOR1 = ',';
    private static final char DEFAULT_SEPARATOR2 = ':';
    private static final char MIN_DIGIT = '0';
    private static final char MAX_DIGIT = '9';

    public boolean isSeparator(char currentChar, Optional<Character> separator) {
        return separator.map(value -> value == currentChar)
                .orElse(isDefaultSeparator(currentChar));
    }

    public boolean isDefaultSeparator(char currentChar) {
        return currentChar == DEFAULT_SEPARATOR1 || currentChar == DEFAULT_SEPARATOR2;
    }

    public boolean isDigit(char currentChar) {
        return currentChar >= MIN_DIGIT && currentChar <= MAX_DIGIT;
    }

    public boolean isNegativeNumber(char currentChar) {
        return currentChar == '-';
    }
}
