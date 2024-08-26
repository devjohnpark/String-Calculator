package stringcalculator;

// 문자열 계산기
// 1. 공백일시 0 으로 출력
// 2. //n과 \n 사이의 문자는 커스텀 구분자로
// 3. 음수시 RuntimeException 예외 처리
// 4. 구분자는 , 와 : 로 구분
public class StringCalculator {

    public int calculate(String input) {

        char separator = getSeparator(input);
        CalculationResult cr = new CalculationResult();
        char currentChar = '0';

        for (int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);
            checkNegativeNumber(currentChar);
            updateCalculationResult(currentChar, separator, cr);
        }

        return resultOfCalculation(cr);
    }

    public static class CalculationResult {
        private int sum;
        private int num;

        public int getSum() { return sum; }
        public int getNum() { return num; }
        public void setSum(int sum) { this.sum = sum; }
        public void setNum(int num) { this.num = num; }
    }

    public void updateCalculationResult(char currentChar, char separator, CalculationResult cr) {
        if (isCharNumber(currentChar)) {
            cr.setNum(cr.getNum() * 10 + (currentChar - '0'));
        } else if (isSeparator(currentChar, separator)) {
            cr.setSum(cr.getSum() + cr.getNum());
            cr.setNum(0);
        }
    }

    public int resultOfCalculation(CalculationResult cr) {
        cr.setSum(cr.getSum() + cr.getNum());
        return cr.getSum();
    }

    public void checkNegativeNumber(char currentChar) {
        if (currentChar == '-') {
            throw new RuntimeException("Negative numbers are not allowed");
        }
    }

    public boolean isSeparator(char currentChar, char separator) {
        return currentChar == separator || currentChar == ',' || currentChar == ':';
    }

    public boolean isCharNumber(char currentChar) {
        return currentChar >= '0' && currentChar <= '9';
    }

    public char getSeparator(String input) {
        String pre = "//";
        String post = "\n";
        char separator = ' ';
        if (isCustomSeparator(input, pre, post)) {
            separator = input.charAt(pre.length());
        }
        return separator;
    }

    public Boolean isCustomSeparator(String input, String pre, String post) {
        return input.startsWith(pre) && input.substring(pre.length() + 1).startsWith(post);
    }
}





