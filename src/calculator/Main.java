package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter first number: ");
            double firstNumber = readDouble(scanner);

            System.out.print("Enter second number: ");
            double secondNumber = readDouble(scanner);

            System.out.print("Choose operation (+, -, *, /): ");
            char operation = scanner.next().trim().charAt(0);

            double result = calculate(firstNumber, secondNumber, operation);

            System.out.println("✅ Result: " + result);

        } catch (Exception e) {
            System.out.println("⚠️ Error: " + e.getMessage());
        }
    }

    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("❌ Invalid input. Please enter a number: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }

    private static double calculate(double num1, double num2, char op) {
        return switch (op) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) throw new IllegalArgumentException("Cannot divide by zero!");
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Invalid operation: " + op);
        };
    }
}