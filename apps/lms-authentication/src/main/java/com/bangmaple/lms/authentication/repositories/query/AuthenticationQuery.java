package com.bangmaple.lms.authentication.repositories.query;

public class AuthenticationQuery {
  public static final String SIGN_IN = "SELECT u.id, u.username, u.fullname, u.email, u.is_activated FROM " +
    "users u WHERE u.username = :username AND u.password = :password";
  public static final String SIGN_UP = "INSERT INTO users (username, password, fullname, email, is_activated) " +
    "VALUES ('maple', '123', 'sfs', 'sadd', false)";
}
