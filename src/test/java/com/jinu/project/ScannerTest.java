package com.jinu.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ScannerTest {
  private Scanner scanner;
  private PrintStream printStream;

  public ScannerTest(InputStream inputStream, PrintStream printStream) {
    this.scanner = new Scanner(inputStream);
    this.printStream = printStream;
  }

  @Test
  void shouldTakeUserInput() {

  }

}
