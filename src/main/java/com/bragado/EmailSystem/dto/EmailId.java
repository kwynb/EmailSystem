package com.bragado.EmailSystem.dto;

import javax.validation.Constraint;

@Constraint(validatedBy = EmailIdValidator.class)
public @interface EmailId {
}
