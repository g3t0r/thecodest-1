package com.janjakubowski.thecodest.exception;

public class CsvImportException extends RuntimeException{
  private CsvImportException(String message) {
    super(message);
  }

  private CsvImportException(Throwable throwable) {
    super(throwable);
  }

  public static CsvImportException incorrectColumnNumber(int number) {
    return new CsvImportException("Incorrect number or columns: " + number);
  }

  public static CsvImportException fromException(Exception e) {
    return new CsvImportException(e);
  }

}
