package stringcalculator;

// regex(regular expressions): 문자열에서 패턴 매칭 작업 수행을 위한 Java API
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toInts(split(text)));
    }

    private boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = Pattern.quote(m.group(1)); // 특수 문자 처리
            return m.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
    }

    private int[] toInts(String[] values) {
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = toPositive(values[i]);
        }
        return numbers;
    }

    private static int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
