package org.geektimes.projects.user.validator.bean.validation;

import org.geektimes.projects.user.domain.User;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidAnnotationValidator implements ConstraintValidator<UserValid, User> {
    private static final Pattern CHINA_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private int idRange;
    private String message;

    public void initialize(UserValid annotation) {
        this.idRange = annotation.idRange();
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {

        // 获取模板信息
        String template = context.getDefaultConstraintMessageTemplate();


        Matcher emailMatcher = CHINA_PATTERN.matcher(value.getPhoneNumber());

        return emailMatcher.matches();
    }
}
