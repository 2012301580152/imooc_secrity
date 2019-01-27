package com.imooc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName MyConstraintValidator
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 14:04
 * @Version 1.0
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        System.out.println(value);
        return false;
    }
}
