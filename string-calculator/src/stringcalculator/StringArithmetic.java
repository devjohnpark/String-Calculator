package stringcalculator;

import java.util.Optional;

// 입력된 문자열을 산술하는 역할
class StringArithmetic {

    public int doArithmetic(String input, CharacterValidator characterValidator) {
        CalculationResult calculationResult = new CalculationResult();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (characterValidator.isNegativeNumber(currentChar)) {
                throw new RuntimeException("Negative numbers are not allowed");
            } else if (characterValidator.isDigit(currentChar)) {
                calculationResult.setDigit(currentChar - '0');
            } else if (characterValidator.isSeparator(currentChar)) {
                calculationResult.addToSum();
            }

        }
        calculationResult.addToSum(); // 마지막 숫자 더하기
        return calculationResult.getSum();
    }

    // 산술 결과 저장하는 역할
    private static class CalculationResult {
        private int sum;
        private int num;

        public int getSum() {
            return sum;
        }

        public int getNum() {
            return num;
        }

        private void setSum(int sum) {
            this.sum = sum;
        }

        private void setNum(int num) {
            this.num = num;
        }

        // 모든 숫자의 총합을 위한 메서드
        public void addToSum() {
            setSum(getSum() + getNum());
            setNum(0);
        }

        // 특정 숫자를 구하기 위한 메서드
        public void setDigit(int digit) {
            setNum(getNum() * 10 + digit);
        }
    }

}
