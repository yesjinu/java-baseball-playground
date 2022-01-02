package com.jinu.project;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
  Calculator calculator = new Calculator();;

  @Test
  void shouldAddTwoNumbers() throws Exception {
    int actual = calculator.operate("1 + 2");
    assertThat(actual).isEqualTo(3);
  }

  @Test
  void shouldAddThreeNumbers() throws Exception {
    int actual = calculator.operate("1 + 2 + 3");
    assertThat(actual).isEqualTo(6);
  }
  
  @Test
  void shouldReturnWhenOnlyOneLiteral() throws Exception {
    int actual = calculator.operate("1");
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void shouldCalculateComplexFormula() throws Exception {
    int actual = calculator.operate("2 + 3 * 4 / 2");
    assertThat(actual).isEqualTo(10);
  }

  @Test
  void shouldBeNumberFormat() {
    assertThatThrownBy(() -> calculator.operate("invalid"))
        .isInstanceOf(NumberFormatException.class);
  }

  @Test
  void shouldBeValidFormula() {
    assertThatThrownBy(() -> calculator.operate("1 + "))
        .isInstanceOf(Exception.class)
        .hasMessageContaining("Invalid");
  }
}
