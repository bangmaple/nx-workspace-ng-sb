package com.bangmaple.lms.authentication.validators;

import com.bangmaple.lms.authentication.services.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import reactor.core.scheduler.Schedulers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UsernameMustUniqueValidator implements ConstraintValidator<UsernameMustUnique, String> {

  private final UsersService usersService;

  @Override
  @SneakyThrows
  public boolean isValid(String username, ConstraintValidatorContext context) {
    return !((boolean)usersService.isUserExistedByUsername(username)
      .subscribeOn(Schedulers.boundedElastic()).toFuture().get());
  }
}
