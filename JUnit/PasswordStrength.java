package com.eclorelavie.passwordstrength;

public class PasswordUtil {
  public static boolean isSrongPassword(String value) {
    
    if (value.length() < 7) return false;
    if (!value.matches(".*[A-Z].*")) return false;
    if (!value.matches(".*[0-9].*")) return false;

    return true;
  }
}
