package com.bangmaple.lms.authentication.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class AlphabetNameWithNumberValidator implements ConstraintValidator<AlphabetName, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !Objects.isNull(value) && value.matches("^[a-zA-Z\\d]*$");
  }
}
