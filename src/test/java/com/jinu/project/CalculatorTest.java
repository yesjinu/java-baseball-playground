package com.jinu.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Scanner;


public class CalculatorTest {
  Calculator calculator = new Calculator();;

  @Test
  void addSimple() {
    int actual = calculator.operate("1 + 2");
    assertThat(actual).isEqualTo(3);
  }

  @Test
  void addComplicate() {
    int actual = calculator.operate("1 + 2 + 3");
    assertThat(actual).isEqualTo(6);
  }
  
  @Test
  void onlyOneInt() {
    int actual = calculator.operate("1");
    assertThat(actual).isEqualTo(1);
  }

  @Test
  void testComplicate() {
    int actual = calculator.operate("2 + 3 * 4 / 2");
    assertThat(actual).isEqualTo(10);
  }
}
