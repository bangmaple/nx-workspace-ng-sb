package com.bangmaple.lms.authentication.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphabetNameWithSpaceValidator implements ConstraintValidator<AlphabetNameWithSpace, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.matches("^[a-zA-Z\\s+]*$");
  }
}
