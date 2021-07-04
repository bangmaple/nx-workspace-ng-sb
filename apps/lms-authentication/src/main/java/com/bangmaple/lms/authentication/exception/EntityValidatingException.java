package com.bangmaple.lms.authentication.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
@Setter
public class EntityValidatingException extends RuntimeException {
  private List<ObjectError> errors;

  public EntityValidatingException(String message) {
    super(message);
  }

  public EntityValidatingException() {
    super();
  }

  public EntityValidatingException setErrors(List<ObjectError> errors) {
    this.errors = errors;
    return this;
  }
}
