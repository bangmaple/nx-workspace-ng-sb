package com.bangmaple.lms.authentication.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AlphabetNameWithSpaceValidator.class)
public @interface AlphabetNameWithSpace {
  String message() default "{error.name.notvalid}";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
