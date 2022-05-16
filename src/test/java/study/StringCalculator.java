package study;

import java.util.Arrays;

public class StringCalculator {

    public static Integer operate(String str) {
        if (isEmpty(str)) {
            return 0;
        }

        return sum(toInts(split(str)));
    }

    private static Integer sum(Integer[] operands) {
        Integer sum = 0;
        for (Integer op: operands) {
            sum += op;
        }
        return sum;
    }

    private static Integer[] toInts(String[] strList) {
        return Arrays.stream(strList).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    private static String[] split(String str) {
        return str.split(",|:");
    }
}
