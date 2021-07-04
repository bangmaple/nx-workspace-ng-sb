package com.bangmaple.lms.authentication.validators;

import com.bangmaple.lms.authentication.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import reactor.core.scheduler.Schedulers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AlphabetNameValidator implements ConstraintValidator<AlphabetName, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.matches("^[a-zA-Z]*$");
  }
}
