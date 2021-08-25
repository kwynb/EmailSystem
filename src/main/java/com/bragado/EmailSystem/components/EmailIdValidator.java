package com.bragado.EmailSystem.components;

import com.bragado.EmailSystem.components.EmailId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailIdValidator implements ConstraintValidator<EmailId, Long> {
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext ctx) {
        Pattern pattern =
                Pattern.compile("^[0-9]*$");
        Matcher matcher = pattern.matcher(id.toString());
        try {
            if (!matcher.matches()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}