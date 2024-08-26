package stringcalculator;

// 문자열 계산기
// 1. 공백일시 0 으로 출력
// 2. //n과 \n 사이의 문자는 커스텀 구분자로
// 3. 음수시 RuntimeException 예외 처리
// 4. 구분자는 , 와 : 로 구분


import java.util.LinkedList;
import java.util.Queue;

// 숫자 하나일때 예외
public class StringCalculator {
    int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        char separator = getSeparator(input);
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') {
                throw new RuntimeException();
            } else if (separator == input.charAt(i)) {
                sum += addNumber(queue);
            } else if (input.charAt(i) == ',' || input.charAt(i) == ':') {
                sum += addNumber(queue);
            } else if (input.charAt(i) >= '0' && input.charAt(i) <= '9'){
//                int value = Integer.parseInt(String.valueOf(input.charAt(i)));
                queue.offer(input.charAt(i) - '0');
            }
        }

        sum += addNumber(queue);

        return sum;
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

    public int addNumber(Queue<Integer> queue) {
        int tmp = 0;
        while (!queue.isEmpty()) {
            tmp = tmp * 10 + queue.poll();
        }
        return tmp;
    }
}





