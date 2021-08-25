package com.bragado.EmailSystem.components;

import javax.validation.Constraint;

@Constraint(validatedBy = EmailIdValidator.class)
public @interface EmailId {
}
