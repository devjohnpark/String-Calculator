package stringcalculator;

import java.util.Optional;

// 문자열 산술자
class StringArithmetic {

    private final SeparatorValidator separatorValidator;

    public StringArithmetic() {
        this.separatorValidator = new SeparatorValidator();
    }

    public int doArithmetic(String input, CalculationResult cr, Optional<Character> customSeparator) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (separatorValidator.isNegativeNumber(currentChar)) {
                throw new RuntimeException("Negative numbers are not allowed");
            }

            if (separatorValidator.isDigit(currentChar)) {
                cr.addToNum(currentChar - '0');
            } else if (separatorValidator.isSeparator(currentChar, customSeparator)) {
                cr.addToSum();
            }

        }
        cr.addToSum(); // 마지막 숫자 더하기
        return cr.getSum();
    }
}
