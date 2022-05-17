package study.baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballTest {
    private final String ANSWER = "123";
    private final Baseball game = new Baseball(ANSWER);


    @Test
    void checkStrike() {
        String result1 = game.guess("123");
        String result2 = game.guess("132");
        String result3 = game.guess("253");
        String result4 = game.guess("456");

        assertThat(result1).isEqualTo("3 Strike");
        assertThat(result2).isEqualTo("1 Strike 2 Ball");
        assertThat(result3).isEqualTo("1 Strike 1 Ball");
        assertThat(result4).isEqualTo("nothing");
    }
}
