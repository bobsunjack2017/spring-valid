package com.demo4.valid;

import javax.validation.ConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty2, Object>
{

    @Override
    public void initialize(NotEmpty2 annotation)
    {
    }

    @Override
    public boolean isValid(Object str, ConstraintValidatorContext constraintValidatorContext)
    {
        return str != null;
    }

}