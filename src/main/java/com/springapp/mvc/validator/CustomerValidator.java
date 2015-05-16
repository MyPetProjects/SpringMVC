package com.springapp.mvc.validator;

import com.springapp.mvc.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: Valentine
 * Date: 11.05.15
 * Time: 0:40
 * To change this template use File | Settings | File Templates.
 */
public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName",
                "User name should not be empty");
    }
}
