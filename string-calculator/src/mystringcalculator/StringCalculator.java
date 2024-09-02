package mystringcalculator;

// 덧셈 문자열 계산기
// 1. 음수 빼고는 문자열 정확히 입력한다고 가정
// 1. 공백 문자열은 0 으로 출력
// 2. 기본 구분자는 , 와 : 로 구분
// 3. 커스텀 구분자는 입련된 문자열 앞부분에서 //과 \n 사이의 문자
// 4. 음수는 RuntimeException 예외 처리
// 5. 추출한 숫자의 총합을 반환.

// 테스트할 경우의 수
// 1. 문자열에서 문자와 숫자가 구분되는지
// 2. 문자열에 '-' 문자가 포함되어 있가면 예외처라가 되는지
// 3. 커스텀 구분자의 문자열 형태인 경우, 문자열 앞부분의 "//;\n"에서 커스텀 구분자 ';'가 추출되는지
// 4. 커스텀 구분자의 의해 "123;321" 에서 123과 321로 분리되는지
// 5. 커스텀 구분자의 문자열 형태가 아닌 경우, 결과값 확인
// 6. 기본 구분자 ','에 의해 "123,321" 에서 123과 321로 분리되는지
// 7. 기본 구분자 ':'에 의해 "123:321" 에서 123과 321로 분리되는지
// 8. 분리된 숫자의 총합이 알맞는지
// 9. 공백 문자열 입력시 0으로 출력되는지

// OOP
// 1. 문자열을 계산하는 클래스
// 2. 문자(구분자/숫자)의 유효성 확인하는 클래스
// 3. 커스텀 구분자를 추출하는 클래스
// 4. 산술 결과를 저장하는 클래스 (문자열 계산자의 내부에서만 팔요하므로 내부 클래스로 작성)

// 문자열을 계산하는 역할
public class StringCalculator {

    private final CharacterValidator characterValidator;

    public StringCalculator() {
        this.characterValidator = new CharacterValidator();
    }

    // 문자열 덧셈을 수행하는 메서드
    public int add(String input) {
        if (isBlank(input)) { return 0; }
        characterValidator.validCustomSeparator(input);
        return doAddition(input);
    }

    // 실제 문자열 덧셈을 수행하는 메서드
    private int doAddition(String input) {
        CalculationResult calculationResult = new CalculationResult();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            checkNegativeNumber(currentChar);
            updateCalculationResult(currentChar, calculationResult);
        }
        return getCalculationResult(calculationResult);
    }

    private void updateCalculationResult(char currentChar, CalculationResult calculationResult) {
        if (characterValidator.isDigit(currentChar)) {
            calculationResult.addDigit(toInts(currentChar));
        } else if (characterValidator.isSeparator(currentChar)) {
            calculationResult.addToSum();
        }
    }

    private int getCalculationResult(CalculationResult calculationResult) {
        calculationResult.addToSum(); // 구분자에 의해 분리되지 못한 마지막 숫자 더하기
        return calculationResult.getSum(); // 합계 반환
    }

    private void checkNegativeNumber(char currentChar) {
        if (characterValidator.isNegativeNumber(currentChar)) {
            throw new RuntimeException("Negative numbers are not allowed");
        }
    }

    private int toInts(char currentChar) {
        return currentChar - '0';
    }

    private boolean isBlank(String input) {
        if (input == null || input.isEmpty()) { return true; }
        return false;
    }

    // 계산 결과 저장하는 역할
    private static class CalculationResult {
        private int sum;
        private int num;

        public int getSum() {
            return sum;
        }

        public int getNum() {
            return num;
        }

        // 모든 숫자의 총합을 위한 메서드
        public void addToSum() {
            sum = getSum() + getNum();
            num = 0;
        }

        // 특정 숫자를 구하기 위한 메서드
        public void addDigit(int digit) {
            num = getNum() * 10 + digit;;
        }
    }
}

