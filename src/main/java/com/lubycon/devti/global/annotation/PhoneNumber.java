package com.lubycon.devti.global.annotation;

import static com.lubycon.devti.global.annotation.PhoneNumberValidator.PHONE_NUMBER_REGEX_PATTERN;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {

  String message() default "must match " + PHONE_NUMBER_REGEX_PATTERN;

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}