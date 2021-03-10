package org.geektimes.projects.user.validator.bean.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserValidAnnotationValidator.class)
public @interface UserValid {

    String message() default "手机号不合法";

    int idRange() default 0;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
