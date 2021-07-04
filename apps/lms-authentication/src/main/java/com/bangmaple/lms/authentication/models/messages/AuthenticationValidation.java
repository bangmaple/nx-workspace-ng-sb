package com.bangmaple.lms.authentication.models.messages;

public class AuthenticationValidation {
  public static final int USERNAME_MIN_LENGTH = 3;

  public static final String USERNAME_NOT_NULL = "Tên đăng nhập không được để trống.";
  public static final String USERNAME_MIN_LENGTH_MESSAGE = "Tên đăng nhập phải lớn hơn " + USERNAME_MIN_LENGTH + " kí tự.";
}
