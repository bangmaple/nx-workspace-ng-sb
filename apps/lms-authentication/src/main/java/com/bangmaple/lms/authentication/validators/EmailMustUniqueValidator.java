package com.bangmaple.lms.authentication.validators;

import com.bangmaple.lms.authentication.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import reactor.core.scheduler.Schedulers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailMustUniqueValidator implements ConstraintValidator<EmailMustUnique, String> {

  private final UsersService usersService;

  @Override
  @SneakyThrows
  public boolean isValid(String email, ConstraintValidatorContext context) {
    return !((boolean)usersService.isUserExistedByEmail(email)
      .subscribeOn(Schedulers.boundedElastic()).toFuture().get());
  }
}
