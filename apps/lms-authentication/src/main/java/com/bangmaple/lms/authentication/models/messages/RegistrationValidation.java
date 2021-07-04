package com.bangmaple.lms.authentication.models.messages;


public class RegistrationValidation {

  public static final String NOT_NULL = "không được để trống";
  public static final String NOT_VALIDATED = "không đúng định dạng";
  public static final String MIN_LENGTH = "phải có độ dài lớn hơn hoặc bằng";
  public static final String MAX_LENGTH = "chỉ có độ dài tối đa là";

  public static final int USERNAME_MIN_LENGTH = 3;
  public static final int USERNAME_MAX_LENGTH = 100;
  public static final int PASSWORD_MIN_LENGTH = 8;
  public static final int PASSWORD_MAX_LENGTH = 100;
  public static final int FULLNAME_MIN_LENGTH = 3;
  public static final int FULLNAME_MAX_LENGTH = 200;


  public static final String USERNAME = "Tên đăng nhập";
  public static final String PASSWORD = "Mật khẩu";
  public static final String FULLNAME = "Tên đầy đủ";
  public static final String EMAIL = "Tài khoản e-mail";


  public static final String USERNAME_NOT_NULL_MESSAGE = USERNAME + " " + NOT_NULL + ".";
  public static final String USERNAME_MIN_LENGTH_MESSAGE = USERNAME + " " + MIN_LENGTH + " 3.";
  public static final String USERNAME_MAX_LENGTH_MESSAGE = USERNAME + " " + MAX_LENGTH + " 100.";
  public static final String PASSWORD_NOT_NULL_MESSAGE = PASSWORD + " " + NOT_NULL + ".";
  public static final String PASSWORD_MIN_LENGTH_MESSAGE = PASSWORD + " " + MIN_LENGTH + " 8.";
  public static final String PASSWORD_MAX_LENGTH_MESSAGE = PASSWORD + " " + MAX_LENGTH + " 100.";
  public static final String FULLNAME_NOT_NULL_MESSAGE = FULLNAME + " " + NOT_NULL + ".";
  public static final String FULLNAME_MIN_LENGTH_MESSAGE = FULLNAME + " " + MIN_LENGTH + " 3.";
  public static final String FULLNAME_MAX_LENGTH_MESSAGE = FULLNAME + " " + MAX_LENGTH + " 200.";
  public static final String EMAIL_NOT_NULL_MESSAGE = EMAIL + " " + NOT_NULL + ".";
  public static final String EMAIL_NOT_VALID_MESSAGE = EMAIL + " " + NOT_VALIDATED + ".";
  public static final String PASSWORD_MUST_MATCH_MESSAGE = "Mật khẩu nhập lại phải trùng với mật khẩu gốc.";
  public static final String USERNAME_NOT_UNIQUE_MESSAGE = "Tên tài khoản đã tồn tại. Hãy sử dụng tên khác";
  public static final String EMAIL_NOT_UNIQUE_MESSAGE = "Tài khoản e-mail này đã bị trùng. Hãy sử dụng tên khác!";
  public static final String NOT_IN_ALPHABET_NAME_MESSAGE = "Chỉ chấp nhận định dạng chữ cái";
}
