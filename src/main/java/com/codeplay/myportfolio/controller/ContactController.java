package com.codeplay.myportfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codeplay.myportfolio.model.Contact;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {

    @RequestMapping(value = { "/contact" })
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute Contact contact, Errors errors) {

        if (errors.hasErrors()) {
            log.error("Contact form validation failed due to : " + errors.toString());
            return "contact";
        }

        return "redirect:/contact";
    }
}
