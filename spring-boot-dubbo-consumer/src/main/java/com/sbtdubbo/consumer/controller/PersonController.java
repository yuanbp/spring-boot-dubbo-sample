package com.sbtdubbo.consumer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbtdubbo.api.domain.Person;

/**
 * Created by Richard on 2017/10/26 0026.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @RequestMapping("personindex")
    public String personIndex(HttpServletRequest request, HttpServletResponse response, Model model) {
        Person person = new Person("张三", "25");
        List<Person> people = new ArrayList<>();
        people.add(new Person("李四", "25"));
        people.add(new Person("王五", "25"));
        people.add(new Person("赵六", "25"));
        model.addAttribute("singlePerson", person);
        model.addAttribute("people", people);
        model.addAttribute("customTitle", "PERSON_INDEX");
        return "personindex";
    }
}
