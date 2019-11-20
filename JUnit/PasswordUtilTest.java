package com.eclorelavie.passwordstrength;
import org.junit.Test;
import static org.junit.Assert.*;


public class PasswordUtilTest {
  @Test
  public void shouldHaveMoreThanSixSymbols() {
    assertFalse(PasswordUtil.isStrongPassword("A1"));
    assertFalse(PasswordUtil.isStrongPassword("Mole12"));

    assertTrue(PasswordUtil.isStrongPassword("Moleskin123"));
  }

  @Test
  public void shouldHaveAtLeastOneDigit() {
    assertFalse(PasswordUtil.isStrongPassword("Dictionary"));
    
    assertTrue(PasswordUtil.isStrongPassword("Dictionary1"));
    assertTrue(PasswordUtil.isStrongPassword("Dictionary123456789"));
  }

  @Test
  public void shouldHaveAtLeastOneCapitalLetter() {
    assertFalse(PasswordUtil.isStrongPassword("computer12345"));
    
    assertTrue(PasswordUtil.isStrongPassword("compUter12345"));
    assertTrue(PasswordUtil.isStrongPassword("COMPUTER12345"));
  }
