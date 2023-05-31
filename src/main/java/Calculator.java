import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.Scanner;

public class Calculator {

    static Logger logger;

    public Calculator(final Logger logger) {
        Calculator.logger = logger;
    }

    public static void main(String... args) {

        System.out.println("Welcome to the calculator!");
        System.out.println("Please enter the numbers.");

        Scanner scanner = new Scanner(System.in);
        Logger logger = new LoggerLogic();
        StringCalculator strCalc = new StringCalculatorImpl(logger);
        String input = scanner.nextLine();


        while (!input.isEmpty()) {
            try {
                if (input.startsWith("scalc '//[") && input.endsWith("]")) {
                    String delimiterSequence = input.split("scalc '//")[1].split("\\[[.]{1,10}]")[0];
                    String numbers = scanner.nextLine();
                    if (numbers.endsWith("'")) {
                        numbers = numbers.split("'")[0];
                        String[] delimitersSplit = delimiterSequence.split("]\\[");
                        delimitersSplit[0] = delimitersSplit[0].split("\\[")[1];
                        delimitersSplit[delimitersSplit.length - 1] = delimitersSplit[delimitersSplit.length - 1].split("]")[0];
                        for (String delimiter : delimitersSplit) {
                            numbers = numbers.replace(delimiter, ",");
                        }
                        int result = strCalc.add(numbers);
                        if (result > 0) {
                            System.out.println("The result is " + result);
                        }
                    }
                } else if (input.startsWith("scalc '") && input.endsWith("'")) {
                    String[] inputArr = input.split("'");
                    int result = strCalc.add(inputArr[1]);
                    if (result > 0) {
                        System.out.println("The result is " + result);
                    }
                }
            } catch (Exception ignored) {
            }
            input = scanner.nextLine();
        }
    }
}



