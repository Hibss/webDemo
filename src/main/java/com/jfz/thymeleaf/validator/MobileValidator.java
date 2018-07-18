package com.jfz.thymeleaf.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @Author : steven.sheng
 * Description : TODO
 * Date : 2018/5/14 15:24
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    private Pattern pattern = Pattern.compile("1(([38]\\d)|(5[^4&&\\d])|(4[579])|(7[0135678]))\\d{8}");

    @Override
    public void initialize(Mobile phone) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return pattern.matcher(value).matches();
    }
}