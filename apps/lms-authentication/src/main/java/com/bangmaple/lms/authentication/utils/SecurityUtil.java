package com.bangmaple.lms.authentication.utils;

import com.bangmaple.lms.authentication.entites.UsersEntity;
import com.bangmaple.lms.authentication.models.AuthenticationRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class SecurityUtil {

  public static final String AUTHORIZATION_TYPE = "Bearer ";
  public static final String TOKEN_RESPONSE = "TOKEN";
  public static final String USER_RESPONSE = "USER";

  private final PasswordEncoder passwordEncoder;

  public UsersEntity comparePassword(AuthenticationRequestModel auth, UsersEntity user) {
    return passwordEncoder.matches(auth.getPassword(), user.getPassword()) ? user : null;
  }
}
