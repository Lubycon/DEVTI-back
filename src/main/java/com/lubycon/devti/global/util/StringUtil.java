package com.lubycon.devti.global.util;

import com.google.re2j.Pattern;

public final class StringUtil {

  public static boolean matches(String input, String regex) {
    Pattern pattern = Pattern.compile(regex);

    return pattern.matches(input);
  }

}
