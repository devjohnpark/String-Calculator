package combination;

// Problem: production code and test code are in the same class
// Result: The class is not clear. And it deploys together to production server
// Solution: Separate production code and test code
public class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }

    // Test Code
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(10, 20));
        System.out.println(calculator.subtract(10, 20));
        System.out.println(calculator.multiply(10, 20));
        System.out.println(calculator.divide(20, 10));
    }
}
