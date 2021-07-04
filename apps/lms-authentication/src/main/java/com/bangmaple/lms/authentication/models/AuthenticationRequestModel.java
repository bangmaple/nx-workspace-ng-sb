package com.bangmaple.lms.authentication.models;

import com.bangmaple.lms.authentication.models.messages.AuthenticationValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestModel {
  @NotNull(message = AuthenticationValidation.USERNAME_NOT_NULL)
  @Size(min = AuthenticationValidation.USERNAME_MIN_LENGTH,
    message = AuthenticationValidation.USERNAME_MIN_LENGTH_MESSAGE)
  private String username;
  private String password;
}
