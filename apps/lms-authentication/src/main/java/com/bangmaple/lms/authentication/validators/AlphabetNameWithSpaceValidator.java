package com.bangmaple.lms.authentication.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class AlphabetNameWithSpaceValidator implements ConstraintValidator<AlphabetNameWithSpace, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (Objects.isNull(value)) {
      return false;
    }
    return value.matches("^[a-zA-Z\\s+]*$");
  }
}
