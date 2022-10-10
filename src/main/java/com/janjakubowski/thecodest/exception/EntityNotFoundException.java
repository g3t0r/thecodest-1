package com.janjakubowski.thecodest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EntityNotFoundException extends HttpStatusCodeException {
  public EntityNotFoundException(Integer id) {
    super(HttpStatus.NOT_FOUND, "No entity with id: " + id);
  }
}
