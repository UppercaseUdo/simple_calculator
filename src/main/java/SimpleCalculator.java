import java.util.Scanner;

import static java.lang.Math.sqrt;

public class SimpleCalculator {
    private static Status status = Status.START;
    protected static final String METHODS = """
                        
                        Supported Methods                   special Numbers
                |-.-| |-.-| |-.-| |-.-| |-.-| |-.-|     |-.-| |-.-| |-.-| |-.-|
                |  a + b |=> a plus b             |     | e  |=> Euler Number |
                |  a - b |=> a minus b            |     | pi |=> Pi           |
                |  a * b |=> a multiplied by b    |     |-.-| |-.-| |-.-| |-.-|
                |  a / b |=> a divided by b       |
                |  a ^ b |=> a to the Power of b  |    Write ans to use the result
                | sqrt a |=> square root of a     |    Write stop to end the app
                |-.-| |-.-| |-.-| |-.-| |-.-| |-.-|
                
                """;
    public static double firstNumber;
    public static int mathMethod;
    public static double secondNumber;
    public static double result;
    
    public static void main(String[] args) { //TODO: Adjust so square root can also be the second number (b). (-> Multiple Inputs)
        greetUser();
        Scanner scanner = new Scanner(System.in);
        userInput(scanner);
    }
    public static void sum(double firstNumber, double secondNumber) { //Math method 1
        result = firstNumber + secondNumber;
    }
    public static void subtract(double firstNumber, double secondNumber) { //Math method 2
        result = firstNumber - secondNumber;
    }
    public static void multiply(double firstNumber, double secondNumber) { //Math method 3
        result = firstNumber * secondNumber;
    }
    public static void divide(double firstNumber, double secondNumber) { //Math method 4
        result = firstNumber / secondNumber;
    }
    public static void firstNumberToThePowerOfSecondNumber(double firstNumber, double secondNumber) { //Math method 4
        result = Math.pow(firstNumber, secondNumber);
    }
    public static void squareRootOf(double firstNumber) { //Math method 5
        result = sqrt(firstNumber);
    }
    public static void greetUser() {
        System.out.println("Hello and welcome to the Simple Calculator.");
        System.out.println("Please leave a space between every Number and every Method");
        System.out.println("Type in methods to see what the Simple Calculator can do.");
    }

    public static void userInput(Scanner scanner) {
        getFirstInput(scanner);
        if (status == Status.START) {
            getSecondInput(scanner);
            if (mathMethod != 5) { getThirdInput(scanner); }
            calculateAndDisplay(scanner);
        } else {
            System.out.println("Thank you for choosing Simple Calculator");
            scanner.close();
        }

    }

    public static void getFirstInput(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            firstNumber = scanner.nextDouble();
        } else {
            String firstInput = scanner.next().toLowerCase();
            switch (firstInput) {
                case "pi" -> firstNumber = Math.PI;
                case "e" -> firstNumber = Math.E;
                case "sqrt" -> mathMethod = 5;
                case "ans" -> firstNumber = result;
                case "methods" -> {
                    System.out.println(METHODS);
                    userInput(scanner);
                }
                case "stop" -> status = Status.STOP;
                default -> {
                    System.out.println("Incorrect Input, please try again");
                    userInput(scanner);
                }
            }
        }
    }
    private static void getSecondInput(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            firstNumber = scanner.nextDouble();
        } else {
            String secondInput = scanner.next().toLowerCase();
            switch (secondInput) {
                case "+" -> mathMethod = 0;
                case "-" -> mathMethod = 1;
                case "*" -> mathMethod = 2;
                case "/" -> mathMethod = 3;
                case "^" -> mathMethod = 4;
                case "ans" -> firstNumber = result;
                case "pi" -> firstNumber = Math.PI;
                case "e" -> firstNumber = Math.E;
                default -> {
                    System.out.println("Incorrect Input, please try again");
                    userInput(scanner);
                }
            }
        }
    }
    private static void getThirdInput(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            secondNumber = scanner.nextDouble();
        } else if (scanner.hasNextLine()) {
            String thirdInput = scanner.next().toLowerCase();
            switch (thirdInput) {
                case "pi" -> secondNumber = Math.PI;
                case "e" -> secondNumber = Math.E;
                case "ans" -> secondNumber = result;
                default -> {
                    System.out.println("Incorrect Input, please try again");
                    userInput(scanner);
                }
            }
        }
    }

    public static void calculateAndDisplay(Scanner scanner) {
        switch (mathMethod) {
            case 0 -> {
                sum(firstNumber, secondNumber);
                System.out.println(firstNumber + " + " + secondNumber + " = " + result);
            }
            case 1 -> {
                subtract(firstNumber, secondNumber);
                System.out.println(firstNumber + " - " + secondNumber + " = " + result);
            }
            case 2 -> {
                multiply(firstNumber, secondNumber);
                System.out.println(firstNumber + " * " + secondNumber + " = " + result);
            }
            case 3 -> {
                divide(firstNumber, secondNumber);
                System.out.println(firstNumber + " / " + secondNumber + " = " + result);
            }
            case 4 -> {
                firstNumberToThePowerOfSecondNumber(firstNumber, secondNumber);
                System.out.println(firstNumber + " ^ " + secondNumber + " = " + result);
            }
            case 5 -> {
                squareRootOf(firstNumber);
                System.out.println("sqrt of " + firstNumber + " = " + result);
            }
        }
        userInput(scanner);
    }
}
