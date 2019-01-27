package com.imooc.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Past;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ClassName MyConstraint
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 14:01
 * @Version 1.0
 */
@Target({ METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
