package separation;

// Problem: All test code in main method.
// Result: If complexity of production code increase, also main method become complex.
// Solution: Separate test code by method.
public class MainCalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(10, 20));
        System.out.println(calculator.subtract(10, 20));
        System.out.println(calculator.multiply(10, 20));
        System.out.println(calculator.divide(20, 10));
    }
}
