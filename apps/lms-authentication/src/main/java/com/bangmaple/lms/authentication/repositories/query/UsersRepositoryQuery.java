package com.bangmaple.lms.authentication.repositories.query;

import com.bangmaple.lms.authentication.security.Roles;

public class UsersRepositoryQuery {
  public static final String SIGN_IN = "SELECT u.id, u.username, u.password, u.fullname, u.email, u.is_activated, " +
    "u.is_locked, r.name as role FROM users u INNER JOIN roles r on u.role_id = r.id WHERE u.username = :username";

  public static final String SIGN_UP = "INSERT INTO users(username, password, fullname, email, is_activated, is_locked, role_id) " +
    "VALUES(:username, :password, :fullname, :email, false, true, " + Roles.ROLE_USER + ")";

}
