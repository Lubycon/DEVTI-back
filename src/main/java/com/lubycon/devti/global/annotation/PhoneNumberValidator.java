package com.lubycon.devti.global.annotation;

import com.lubycon.devti.global.util.StringUtil;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PhoneNumberValidator implements
    ConstraintValidator<com.lubycon.devti.global.annotation.PhoneNumber, String> {

  protected static final String PHONE_NUMBER_REGEX_PATTERN = "(\\d{3})-(\\d{3,4})-(\\d{4})";
  protected static final String PHONE_NUMBER_REGEX_FOR_RPA_PATTERN = "RPA_TEST_.*(\\d{3})-(\\d{3,4})-(\\d{4})";

  @Override
  public boolean isValid(final String s,
      final ConstraintValidatorContext constraintValidatorContext) {
    return s == null || StringUtil.matches(s, PHONE_NUMBER_REGEX_PATTERN) || StringUtil
        .matches(s, PHONE_NUMBER_REGEX_FOR_RPA_PATTERN);
  }
}
