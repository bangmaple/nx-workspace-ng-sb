package com.bangmaple.lms.authentication.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AlphabetNameValidator.class)
public @interface AlphabetNameWithNumber {
  String message() default "{error.name.number.notvalid}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
