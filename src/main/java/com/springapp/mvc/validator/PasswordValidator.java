package com.springapp.mvc.validator;

import com.springapp.mvc.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Valentine
 * Date: 12.05.15
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class PasswordValidator implements Validator {
    private static final int MIN_PASSWORD_LENGTH = 6;
    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password",
                "Please provide password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
                "required.confirmPassword", "Please confirm password");
        Customer customer = (Customer) o;
        if (customer.getPassword().trim().length() < MIN_PASSWORD_LENGTH)
            errors.rejectValue("password", "min.password.length", "Password is too short");
        if (!customer.getPassword().equals(customer.getConfirmPassword()))
            errors.rejectValue("password", "nomatch.password", new Object[] {MIN_PASSWORD_LENGTH},
                    "Password should be at least " + MIN_PASSWORD_LENGTH + " characters long");
    }
}
