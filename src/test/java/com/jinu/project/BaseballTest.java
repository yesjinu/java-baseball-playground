package com.jinu.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class BaseballTest {
    String answer = "123";
    Baseball baseball = new Baseball(answer);

    @Test
    void shouldReturnAnswer() {
        String actual = baseball.getAnswer();
        assertThat(actual).isEqualTo(answer);
    }

    @Test
    void shouldNothingMatched() {
        String assumption = "456";
        int[] result = baseball.guess(assumption);
        int[] actual = { 0, 0 };
        assertTrue(Arrays.equals(result, actual));
    }

    @Test
    void shouldOneBall() {
        String assumption = "451";
        int[] result = baseball.guess(assumption);
        int[] actual = { 0, 1 };   
        assertTrue(Arrays.equals(result, actual));
    }

    @Test
    void shouldOneStrike() {
        String assumption = "145";
        int[] result = baseball.guess(assumption);
        int[] actual = { 1, 0 };
        assertTrue(Arrays.equals(result, actual));
    }
    
    @Test
    void shouldTwoBall() {
        String assumption = "412";
        int[] result = baseball.guess(assumption);
        int[] actual = { 0, 2 };
        assertTrue(Arrays.equals(result, actual));
    }
    
    @Test
    void shouldOneStrikeOneBall() {
        String assumption = "142";
        int[] result = baseball.guess(assumption);
        int[] actual = { 1, 1 };
        assertTrue(Arrays.equals(result, actual));
    }

}
