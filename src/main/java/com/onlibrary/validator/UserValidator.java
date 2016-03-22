package com.onlibrary.validator;

/**
 * Created by harkonnen on 21.03.16.
 */

import com.onlibrary.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlibrary.entity.User;
public class UserValidator implements Validator {

    @Autowired
    private UsersDao usersService;

    //which objects can be validated by this validator

    public boolean supports(Class<?> paramClass) {
        return User.class.equals(paramClass);
    }


    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");

        User user = (User) obj;
        if(usersService.exists(user.getUsername())) {
            errors.rejectValue("username", "DuplicateKey.user.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
    }
}

