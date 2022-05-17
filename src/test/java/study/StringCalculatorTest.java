package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {
    @Test
    void zero_when_null_or_blank_string() {
        String nullStr = null;
        String blankStr = "";

        Integer nullResult = StringCalculator.operate(nullStr);
        Integer blankResult = StringCalculator.operate(blankStr);

        assertThat(nullResult).isEqualTo(0);
        assertThat(blankResult).isEqualTo(0);
    }

    @Test
    void itself_when_length_is_1() {
        String oneStr = "1";
        String twoStr = "2";
        String sevenStr = "7";

        Integer oneResult = StringCalculator.operate(oneStr);
        Integer twoResult = StringCalculator.operate(twoStr);
        Integer sevenResult = StringCalculator.operate(sevenStr);

        assertThat(oneResult).isEqualTo(1);
        assertThat(twoResult).isEqualTo(2);
        assertThat(sevenResult).isEqualTo(7);
    }

    @Test
    void add_multipe() {
        String str1 = "1 + 2";
        String str2 = "1 + 2 + 3";

        Integer str1Result = StringCalculator.operate(str1);
        Integer str2Result = StringCalculator.operate(str2);

        assertThat(str1Result).isEqualTo(3);
        assertThat(str2Result).isEqualTo(6);
    }

    @Test
    void calc_multiple() {
        String str1 = "1 + 2 / 3";
        String str2 = "2 - 1 * 4 * 10 - 7";

        Integer str1Result = StringCalculator.operate(str1);
        Integer str2Result = StringCalculator.operate(str2);

        assertThat(str1Result).isEqualTo(1);
        assertThat(str2Result).isEqualTo(33);
    }


}
