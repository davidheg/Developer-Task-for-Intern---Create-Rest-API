package com.david.project1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController{

    Storage store = new Storage();
    SortedListResource sortLists;
    @PostConstruct
    public void init(){
        sortLists = new SortedListResource(store);
        System.out.println("the object has been initilized");
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");

        return "hello";
    }
    @RequestMapping(value = "/sortedLists", method = RequestMethod.POST)
    public void get(ArrayList<Integer> input) {
        sortLists.acceptList(input);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView student(@ModelAttribute("SortedListResource") SortedListResource sortLists) {
        List<Integer> input = new ArrayList<>();
        return new ModelAndView("student", "command", Arrays.asList());
    }




}