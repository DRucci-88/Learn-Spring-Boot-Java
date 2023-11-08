package com.lerucco.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lerucco.thymeleafdemo.model.City;
import com.lerucco.thymeleafdemo.model.Country;
import com.lerucco.thymeleafdemo.model.ProgrammingLanguage;
import com.lerucco.thymeleafdemo.model.Student;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {

    @Value("${cities}")
    private List<String> citiesName;

    private List<Country> countries;
    private List<City> cities;
    private List<ProgrammingLanguage> programmingLanguages;

    @PostConstruct
    public void initializationCountry() {
        countries = new ArrayList<>();
        List<String> countriesName = Arrays.asList("Indonesia", "America", "India", "Hong Kong", "Irlandia");
        for (int i = 0; i < countriesName.size(); i++) {
            countries.add(new Country(i + 1, countriesName.get(i)));
        }
    }

    @PostConstruct
    public void initializationCity() {
        cities = new ArrayList<>();
        for (int i = 0; i < citiesName.size(); i++) {
            cities.add(new City(i + 1, citiesName.get(i)));
        }
    }

    @PostConstruct
    public void initializationProgrammingLanguage() {
        programmingLanguages = new ArrayList<>();
        List<String> programmingLanguagesName = Arrays.asList("Java", "Go", "Javascript", "C#", "Dart", "Python");
        for (int i = 0; i < programmingLanguagesName.size(); i++) {
            programmingLanguages.add(new ProgrammingLanguage(i + 1, programmingLanguagesName.get(i)));
        }
    }

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        // Create a new Student Object
        Student student = new Student();

        // Add student object as a Model Attribute
        model.addAttribute("student", student);

        model.addAttribute("countries", countries);

        model.addAttribute("cities", cities);

        model.addAttribute("programmingLanguages", programmingLanguages);
        System.out.println(countries);
        System.out.println(cities);
        System.out.println(citiesName);
        System.out.println(programmingLanguages);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student, Model model) {

        Country country = countries.get(student.getCountryId() - 1);
        City city = cities.get(student.getCityId() - 1);
        ProgrammingLanguage pl = programmingLanguages.get(student.getProgrammingLanguageId() - 1);
        System.out.println(student);
        System.out.println(country);
        System.out.println(city);
        System.out.println(pl);

        model.addAttribute("student", student);
        model.addAttribute("country", country);
        model.addAttribute("city", city);
        model.addAttribute("programmingLanguage", pl);
        return "student-confirmation";
    }
}

// WebFlux - Async