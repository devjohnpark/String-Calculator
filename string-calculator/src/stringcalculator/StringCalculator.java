package stringcalculator;

// 문자열 계산기
// 1. 공백일시 0 으로 출력
// 2. //n과 \n 사이의 문자는 커스텀 구분자로
// 3. 음수시 RuntimeException 예외 처리
// 4. 구분자는 , 와 : 로 구분

// OOP
// 1. 문자열 계산하는 역할
// 2. 구분자 숫자 유효성 확인하는 역할
// 3. 커스텀 구분자 추출하는 역할
// 4. 산술 결과 저장하는 역할
// 5. 입력된 문자열을 산술하는 역할

import java.util.Optional;

// 문자열 계산하는 역할
public class StringCalculator {

    private final StringArithmetic stringArithmetic;
    private final CharacterValidator characterValidator;

    public StringCalculator() {
        this.stringArithmetic = new StringArithmetic();
        this.characterValidator = new CharacterValidator();
    }

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        characterValidator.checkCustomSeparator(input);
        return stringArithmetic.doArithmetic(input, characterValidator);
    }
}


//public class StringCalculator {
//
//    public int calculate(String input) {
//        if (input == null || input.isEmpty()) {
//            return 0;
//        }
//
//        char customSeparator = getSeparator(input);
//        CalculationResult cr = new CalculationResult();
//
//        for (int i = 0; i < input.length(); i++) {
//            char currentChar = input.charAt(i);
//            checkNegativeNumber(currentChar);
//            updateCalculationResult(currentChar, customSeparator, cr);
//        }
//        return resultOfCalculation(cr);
//    }
//
//    private static class CalculationResult {
//        private int sum;
//        private int num;
//
//        public int getSum() { return sum; }
//        public int getNum() { return num; }
//        public void setSum(int sum) { this.sum = sum; }
//        public void setNum(int num) { this.num = num; }
//    }
//
//    private void updateCalculationResult(char currentChar, char customSeparator, CalculationResult cr) {
//        if (isDigit(currentChar)) {
//            cr.setNum(cr.getNum() * 10 + (currentChar - '0'));
//        } else if (isSeparator(currentChar, customSeparator)) {
//            cr.setSum(cr.getSum() + cr.getNum());
//            cr.setNum(0);
//        }
//    }
//
//    private int resultOfCalculation(CalculationResult cr) {
//        cr.setSum(cr.getSum() + cr.getNum());
//        return cr.getSum();
//    }
//
//    private void checkNegativeNumber(char currentChar) {
//        if (currentChar == '-') {
//            throw new RuntimeException("Negative numbers are not allowed");
//        }
//    }
//
//    private boolean isSeparator(char currentChar, char customSeparator) {
//        return currentChar == customSeparator || currentChar == ',' || currentChar == ':';
//    }
//
//    private boolean isDigit(char currentChar) {
//        return currentChar >= '0' && currentChar <= '9';
//    }
//
//    private char getSeparator(String input) {
//        if (isCustomSeparator(input)) {
//            return input.charAt(SEPARATOR_PREFIX.length());
//        }
//        return ' ';
//    }
//
//    private Boolean isCustomSeparator(String input) {
//        return input.startsWith(StringCalculator.SEPARATOR_PREFIX) && input.substring(StringCalculator.SEPARATOR_PREFIX.length() + 1).startsWith(StringCalculator.SEPARATOR_SUFFIX);
//    }
//}
//
//
