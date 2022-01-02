package com.jinu.project;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
  
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    Calculator calculator = new Calculator();

    while (true) {
      System.out.println("Enter formula");
      String userInput = scanner.nextLine();

      if (userInput.equalsIgnoreCase("exit")) {
        scanner.close();
        System.out.println("Good Bye");
        System.exit(0);
      }

      int result = calculator.operate(userInput);
      System.out.println(result);
    }
  }
  

  int operate(String input) throws Exception {
    String[] parsedInput = this.parseOnSpace(input);
    
    this.validateInput(parsedInput);

    return getCalculatedResult(parsedInput);
  }

  private void validateInput(String[] input) throws Exception {
    if (input.length % 2 != 1) {
      throw new Exception("Invalid formula");
    }
  }


  private String[] parseOnSpace(String input) {
    return input.split(" ");
  }

  
  private int getCalculatedResult(String[] formula) {
    if (formula.length == 1) {
      return this.getFinalResult(formula);
    }

    String[] reducedFormula = this.calcOneStep(formula);

    return getCalculatedResult(reducedFormula);
  }

  private String[] calcOneStep(String[] formula) {
    int firstTwoResult = this.calcFirstTwo(formula);
    String[] splicedFormula = Arrays.copyOfRange(formula, 3, formula.length);

    String[] reducedFormula = pushFront(firstTwoResult, splicedFormula);
    return reducedFormula;
  }

  private String[] pushFront(int firstTwoResult, String[] splicedFormula) {
    String[] reducedInput = new String[splicedFormula.length + 1];
    
    reducedInput[0] = this.intToString(firstTwoResult);

    for (int i = 1; i < splicedFormula.length + 1; i++) {
      reducedInput[i] = splicedFormula[i - 1];
    }

    return reducedInput;
  }

  private int calcFirstTwo(String[] input) {
    int lnum = this.stringToInt(input[0]);
    String operator = input[1];
    int rnum = this.stringToInt(input[2]);

    return calcTwoOperands(lnum, operator, rnum);    
  }  


  private int getFinalResult(String[] input) {
    return this.stringToInt(input[0]);
  }

  private int stringToInt(String strNum) {
    return Integer.parseInt(strNum);
  }

  private String intToString(int num) {
    return String.valueOf(num);
  }
  
  private int calcTwoOperands(int lnum, String operator, int rnum) {
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
