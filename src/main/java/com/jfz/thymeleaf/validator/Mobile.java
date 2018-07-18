package com.jfz.thymeleaf.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/14 15:23
 */
@Constraint(validatedBy = MobileValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Mobile {

    String message() default "手机号格式不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
