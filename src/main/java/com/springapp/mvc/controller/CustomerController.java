package com.springapp.mvc.controller;

import com.springapp.mvc.model.Customer;
import com.springapp.mvc.validator.AddressValidator;
import com.springapp.mvc.validator.CustomerValidator;
import com.springapp.mvc.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Valentine
 * Date: 11.05.15
 * Time: 1:15
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerValidator customerValidator;
    @Autowired
    private PasswordValidator passwordValidator;
    @Autowired
    private AddressValidator addressValidator;

    @ModelAttribute("skillSet")
    public List<String> populateSkillSet() {
        return new ArrayList<>(Arrays.asList("Excel", "Java", "Python"));
    }

    @ModelAttribute("citizenship")
    public Map<String, String> populateCitizenship() {
        Map<String, String> citizenship = new LinkedHashMap<>();
        citizenship.put("UKR", "Ukrainian");
        citizenship.put("RUS", "Russian");
        citizenship.put("USA", "United States");
        return citizenship;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {
/*
        List<String> skillSet = new ArrayList<>(Arrays.asList("Excel", "Java", "Python"));
        model.addAttribute("skillSet", skillSet);
        Map<String, String> citizenship = new LinkedHashMap<>();
        citizenship.put("UKR", "Ukrainian");
        citizenship.put("RUS", "Russian");
        citizenship.put("USA", "United States");
        model.addAttribute("citizenship", citizenship);
*/
        Customer customer = new Customer();
        customer.setUserName("insert user name");
        customer.setResident(true);
        List<String> defaultLanguages = Arrays.asList("Russian");
        customer.setLanguages(defaultLanguages);
        List<String> defaultSkillSet = Arrays.asList("Java");
        customer.setSkills(defaultSkillSet);
        List<String> defaultCitizenship = Arrays.asList("UKR");
        customer.setCitizenship(defaultCitizenship);
        model.addAttribute("customer", customer);

        return "customerForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("customer") Customer customer,
                                BindingResult result, SessionStatus status) {
        //customerValidator.validate(customer, result);
        //passwordValidator.validate(customer, result);
        addressValidator.validate(customer, result);
        if (result.hasErrors()) {
            return "customerForm";
        } else {
            status.setComplete();
            return "customerSuccess";
        }
    }
}
