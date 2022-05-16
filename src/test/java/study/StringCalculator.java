package study;

import java.util.Arrays;

public class StringCalculator {

    public static Integer operate(String str) {
        if (isEmpty(str)) {
            return 0;
        }

        String[] splittedStr = split(str);

        if (splittedStr.length == 1) {
            return Integer.parseInt(splittedStr[0]);
        }

        Integer result = Integer.parseInt(splittedStr[0]);
        for (Integer idx = 1; idx < splittedStr.length; idx += 2) {
            System.out.println(Arrays.toString(splittedStr));
            switch (splittedStr[idx]) {
                case "+":
                    result += Integer.parseInt(splittedStr[idx + 1]);
                    break;
                case "-":
                    result -= Integer.parseInt(splittedStr[idx + 1]);
                    break;
                case "*":
                    result *= Integer.parseInt(splittedStr[idx + 1]);
                    break;
                case "/":
                    result /= Integer.parseInt(splittedStr[idx + 1]);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        return result;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    private static String[] split(String str) {
        return Arrays.stream(str.split(" ")).map(String::trim).toArray(String[]::new);
    }
}
