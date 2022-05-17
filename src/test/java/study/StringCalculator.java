package study;

import java.util.Arrays;

public class StringCalculator {

    public static Integer operate(String formula) {
        if (isEmpty(formula)) {
            return 0;
        }

        return calculate(parse(formula));
    }

    private static Integer calculate(String[] parsedFormula) {
        if (parsedFormula.length == 1) {
            return Integer.parseInt(parsedFormula[0]);
        }

        return calculate(reduce(parsedFormula)); // calculate recursively
    }

    private static String[] reduce(String[] parsedFormula) {
        parsedFormula[2] = calcFirstTwo(parsedFormula).toString();
        String[] reducedFormula = Arrays.copyOfRange(parsedFormula, 2, parsedFormula.length);

        return reducedFormula;
    }

    private static Integer calcFirstTwo (String[] parsedFormula) {
        Integer left = Integer.parseInt(parsedFormula[0]);
        String operator = parsedFormula[1];
        Integer right = Integer.parseInt(parsedFormula[2]);

        return operate(left, operator, right);
    }

    private static Integer operate(Integer left, String operator, Integer right) {
        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    private static String[] parse(String str) {
        return Arrays.stream(str.split(" ")).map(String::trim).toArray(String[]::new);
    }
}
