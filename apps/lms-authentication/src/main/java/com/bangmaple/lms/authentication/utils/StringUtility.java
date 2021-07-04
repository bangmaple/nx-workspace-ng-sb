package com.bangmaple.lms.authentication.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public final class StringUtility
{
  /**
   * A String for a space character.
   */
  public static final String SPACE = " ";
  public static final String SEMICOLON = ";";
  public static final String COMMA = ",";
  public static final String SLASH = "/";

  /**
   * The empty String {@code ""}.
   */
  public static final String EMPTY = "";

  public static final String NULL_STR = "null";

  private StringUtility()
  {
  }

  /**
   * Check a NULL string.
   *
   * @param s
   * @return boolean
   */
  public static boolean isNull(String s)
  {
    return ((s == null) || (s.length() == 0) || StringUtility.NULL_STR.equalsIgnoreCase(s));
  }

  /**
   * Return an empty string if it is null.
   * @param src
   * @return String
   */
  public static String cleanString(String src)
  {
    return isNull(src) ? EMPTY : src.trim();
  }

  /**
   * Limit a string if it exceeds the max length.
   * @param s
   * @param maxLength
   * @return String
   */
  public static String limitStringLength(String s, int maxLength)
  {
    if (!Optional.ofNullable(s).isPresent())
    {
      return s;
    }

    if (s.length() > maxLength)
    {
      return s.substring(0, maxLength - 3) + "...";
    }

    return s;
  }

  /**
   * Return a string which is concatenated by 2 input strings.
   * @param str1
   * @param str2
   * @return String
   */
  public static String concatLanguageStrings(String str1, String str2)
  {
    if (Optional.ofNullable(str1).isPresent() && Optional.ofNullable(str2).isPresent())
    {
      if (str1.contains(str2))
      {
        return str1;
      }
      return str1.concat(str2);
    }
    else
    {
      return null;
    }
  }
  /**
   * Convert to string with separator
   * @param string
   * @param number
   * @param separator
   * @return
   */
  public static String concatValue(String string, Long number, String separator) {
    return string.concat(separator).concat(String.valueOf(number));
  }

  /**
   * Split a string to an array by separator.
   * @param s
   * @param separator
   * @return List<String>
   */
  public static final List<String> splitString(String s, String separator) {
    if (s == null || s.isEmpty()) {
      return new ArrayList<>();
    }
    return Stream.of(s.split(separator)).collect(Collectors.toList());
  }

  /**
   * Check whether a string is empty
   * @param s
   * @return boolean
   */
  public static final boolean isEmpty(String s) {
    return (s == null || s.trim().isEmpty());
  }

  /**
   * Check whether a string matches a given regular expression.
   * @param s
   * @param regex
   * @return boolean
   */
  public static final boolean matchRegex(String s, String regex) {
    if (s == null) {
      return false;
    }
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(s);
    return matcher.matches();
  }

  /**
   * Replace non digits
   * @param s
   * @return String
   */
  public static final String replaceNonDigits(String s) {
    if (s == null) {
      return null;
    }
    return s.replaceAll("[^0-9]", "");
  }

  /**
   * Convert a string to upper case
   * @param s
   * @return String
   */
  public static final String toUpperCase(String s) {
    if (s == null) {
      return null;
    }
    return s.toUpperCase();
  }

  public static String capitalize(String s) {
    if (s == null) {
      return null;
    }
    if (s.length() == 1) {
      return s.toUpperCase();
    }
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  public static String toCamelCase(final String str) {
    if (str == null) {
      return "";
    }

    String text = str.replaceAll("[^\\w\\s]", "").toLowerCase();
    List<String> listStrings = Stream.of(text.split(" "))
        .filter(s -> !s.trim().isEmpty()).collect(Collectors.toList());
    if (listStrings.isEmpty()) {
      return "";
    }

    StringBuilder builder = new StringBuilder();
    builder.append(listStrings.get(0));
    for (int i = 1; i < listStrings.size(); i++) {
      builder.append(StringUtility.capitalize(listStrings.get(i)));
    }
    return builder.toString();
  }

  /**
   * Check data string is exceed specific length
   * @param data
   * @param length
   * @return true if exceeded, otherwise return false
   */
  public static boolean isExceedLength(String data, int length) {
    if (isEmpty(data)) {
      return false;
    }
    return data.length() > length;
  }

  /**
   * Replace an empty string by null value
   * @param s
   * @return String
   */
  public static String replaceEmptyStringByNullValue(String s) {
    return (isEmpty(s) ? null : s);
  }

  /**
   * Convert list to string
   * @param data
   * @param delimiter
   * @return String
   */
  public static String convertListToString(List<String> list, String delimiter) {
    if (Objects.isNull(list) || list.isEmpty()) {
      return null;
    }
    return String.join(delimiter, list);
  }
}
