package com.bangmaple.lms.authentication.validators;

import com.bangmaple.lms.authentication.models.RegistrationRequestModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, RegistrationRequestModel> {
  @Override
  public boolean isValid(RegistrationRequestModel registration, ConstraintValidatorContext context) {
    String password = registration.getPassword();
    String rePassword = registration.getRePassword();
    if ((Objects.isNull(password) || password.length() == 0)
      && Objects.isNull(rePassword)) {
      return true;
    }
    return !Objects.isNull(rePassword) && password.equals(rePassword);
  }
}
