package lesson12;

import java.util.Scanner;

/**
 * Created by l1s on 12.04.17.
 */
public class EvilCalculator {

    public static void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter expression: ");

            String line = sc.nextLine();

            if ("exit".equals(line))
                break;

            try {
                System.out.println("Answer is: " + calculate(line));
            }
            catch (CalcException ex) {
                System.err.println("Error occurred: ");

                ex.printStackTrace();
            }
        }
    }

    private static int calculate(String line) throws CalcException {
        if (!line.contains("+") && !line.contains("-") && !line.contains("*") && !line.contains("/"))
            throw new CalcException("Expression must contain: '+', '-', '*' or '/': " + line);

        String[] operands = line.split(" ");

        if (operands.length != 3)
            throw new CalcException("Expression must have only 3 operands separated with space (2 + 2): " + line);

        OPERATION operator = OPERATION.parse(operands[1]);

        int op1 = parseOperand(operands[0]);
        int op2 = parseOperand(operands[2]);

        return operator.apply(op1, op2);
    }

    private static int parseOperand(String str) throws CalcException {
        try {
            return Integer.parseInt(str);
        }
        catch (NumberFormatException ex) {
            throw new CalcException("Wrong operand, must be only integer number: " + str, ex);
        }
    }

    private enum OPERATION {
        PLUS, MINUS, MULTIPLY, DIVIDE;

        int apply(int a, int b) throws CalcException {
            switch (this) {
                case PLUS:
                    return a + b;
                case MINUS:
                    return a - b;
                case MULTIPLY:
                    return a * b;
                case DIVIDE:
                    return a / b;
            }
            throw new CalcException("Invalid operator" + this);
        }

        static OPERATION parse(String str) throws CalcException {
            switch (str) {
                case "+":
                    return PLUS;
                case "-":
                    return MINUS;
                case "*":
                    return MULTIPLY;
                case "/":
                    return DIVIDE;
            }
            throw new CalcException("Invalid operator" + str);
        }
    }
}
