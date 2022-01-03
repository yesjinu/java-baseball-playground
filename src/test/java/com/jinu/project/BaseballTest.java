package com.jinu.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {
    String answer = "123";
    Baseball baseball = new Baseball(answer);

    @Test
    void shouldReturnAnswer() {
        String actual = baseball.getAnswer();
        assertThat(actual).isEqualTo(answer);
    }

    // @Test
    // void shouldBeNothing() {
    //     String assumption = "456";
    //     baseball.guess(assumption);
    // }

}
