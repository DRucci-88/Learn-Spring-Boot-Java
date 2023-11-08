package com.lerucco.thymeleafmvc.Controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lerucco.thymeleafmvc.model.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

    // Add an InitBinder ... to convert trim input strings
    // Remove leading and trailing whitespace
    // Resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult, // Result of Validation
            Model model // Binding
    ) {
        System.out.println("First Name: |" + customer.getFirstName() + "|");
        System.out.println(bindingResult.toString());
        System.out.println("\n\n\n\n");
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation";
    }
}
