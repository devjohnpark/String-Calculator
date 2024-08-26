package separation;

// Problem: Simply prints the result value of the method execution to the console. And all methods are executed in main method.
// Result: It needs to manually check value printed on the console. Even if testing just one method, tests for all methods are executed.
// Solution: Add junit test library that can automatically check the result value of each method.
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        add(cal);
        subtract(cal);
        multiply(cal);
        divide(cal);
    }

    private static void add(Calculator cal) {
        System.out.println(cal.add(10, 20));
    }

    private static void subtract(Calculator cal) {
        System.out.println(cal.subtract(10, 20));
    }

    private static void multiply(Calculator cal) {
        System.out.println(cal.multiply(10, 20));
    }

    private static void divide(Calculator cal) {
        System.out.println(cal.divide(20, 10));
    }
}
