package com.springapp.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Valentine
 * Date: 10.05.15
 * Time: 19:47
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String getMovie(@PathVariable String name, ModelMap model) {
        model.addAttribute("movie", name);
        return "list";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getDefaultMovie(ModelMap model) {
        model.addAttribute("movie", "Default movie");
        return "list";
    }
}
