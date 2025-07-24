package com.dendev.school_service.exception;

import jakarta.ws.rs.NotFoundException;

public class SchoolException extends NotFoundException {
  public SchoolException(String message) {
    super(message);
  }
}
