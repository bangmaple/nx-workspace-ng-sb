package com.bangmaple.lms.authentication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestModel {
  private String username;
  private String password;
  private String rePassword;
  private String fullname;
  private String email;
}
