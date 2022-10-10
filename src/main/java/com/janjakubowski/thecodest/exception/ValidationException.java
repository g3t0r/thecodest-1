package com.janjakubowski.thecodest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ValidationException extends HttpStatusCodeException {
  public ValidationException(String reason) {
    super(HttpStatus.BAD_REQUEST, reason);
  }

}
