package com.jinu.project;

public class Calculator {
  int operate(String input) {
    String[] parsedInput = input.split(" ");

    int result = calculate(parsedInput);

    return result;
  }

  private int calculate(String[] input) {
    if (input.length == 1) {
      return Integer.parseInt(input[0]);
    }

    int lnum = Integer.parseInt(input[0]);
    String operator = input[1];
    int rnum = Integer.parseInt(input[2]);

    int result = calcTwo(lnum, operator, rnum);
    
    String[] newInput = new String[input.length - 2];
    newInput[0] = String.valueOf(result);

    for (int i = 1; i < input.length - 2; i++) {
      newInput[i] = input[i + 2];
    }

    return calculate(newInput);
  }
  
  private int calcTwo(int lnum, String operator, int rnum) {
    switch (operator) {
      case "+":
        return lnum + rnum;
      case "-":
        return lnum - rnum;
      case "*":
        return lnum * rnum;
      case "/":
        return lnum / rnum;
      default:
        return 0;
    }
  }
}
