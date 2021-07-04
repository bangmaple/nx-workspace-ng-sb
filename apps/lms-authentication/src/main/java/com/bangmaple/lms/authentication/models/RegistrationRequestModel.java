package com.bangmaple.lms.authentication.models;

import com.bangmaple.lms.authentication.validators.*;
import com.bangmaple.lms.authentication.models.messages.RegistrationValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatch(message = RegistrationValidation.PASSWORD_MUST_MATCH_MESSAGE)
@NotNull(message = "not null")
public class RegistrationRequestModel {

  @NotNull(message = RegistrationValidation.USERNAME_NOT_NULL_MESSAGE)
  @Size(min = RegistrationValidation.USERNAME_MIN_LENGTH,
    message = RegistrationValidation.USERNAME_MIN_LENGTH_MESSAGE)
  @Size(max = RegistrationValidation.USERNAME_MAX_LENGTH,
    message = RegistrationValidation.USERNAME_MAX_LENGTH_MESSAGE)
  @UsernameMustUnique(message = RegistrationValidation.USERNAME_NOT_UNIQUE_MESSAGE)
  @AlphabetName(message = RegistrationValidation.NOT_IN_ALPHABET_NAME_MESSAGE)
  private String username;

  @NotNull(message = RegistrationValidation.PASSWORD_NOT_NULL_MESSAGE)
  @Size(min = RegistrationValidation.PASSWORD_MIN_LENGTH,
    message = RegistrationValidation.PASSWORD_MIN_LENGTH_MESSAGE)
  @Size(max = RegistrationValidation.PASSWORD_MAX_LENGTH,
    message = RegistrationValidation.PASSWORD_MAX_LENGTH_MESSAGE)
  private String password;

  private String rePassword;

  @NotNull(message = RegistrationValidation.FULLNAME_NOT_NULL_MESSAGE)
  @Size(min = RegistrationValidation.FULLNAME_MIN_LENGTH,
    message = RegistrationValidation.FULLNAME_MIN_LENGTH_MESSAGE)
  @Size(max = RegistrationValidation.FULLNAME_MAX_LENGTH,
    message = RegistrationValidation.FULLNAME_MAX_LENGTH_MESSAGE)
  @AlphabetNameWithSpace(message = RegistrationValidation.NOT_IN_ALPHABET_NAME_MESSAGE)
  private String fullname;

  @NotNull(message = RegistrationValidation.EMAIL_NOT_NULL_MESSAGE)
  @Email(message = RegistrationValidation.EMAIL_NOT_VALID_MESSAGE)
  @EmailMustUnique(message = RegistrationValidation.EMAIL_NOT_UNIQUE_MESSAGE)
  private String email;
}
