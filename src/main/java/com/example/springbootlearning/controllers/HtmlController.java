package com.example.springbootlearning.controllers;

import com.example.springbootlearning.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HtmlController {
    @GetMapping("/hello")
    public String renderHelloWorld() {
        return "test";
    }

    // http://localhost:8080/send-attributes?category=tees
    @GetMapping("/send-attributes")
    public String sendAttributes(Model model, @RequestParam String category) {
        model.addAttribute("title", "asd");
        ArrayList<String> foods = new ArrayList<>();
        foods.add("beef");
        foods.add("orange");
        foods.add("apple");
        model.addAttribute("foods", foods);
        model.addAttribute("category", category);

        return "attributes";
    }

    // De lytter efter requests
    @GetMapping("/create-student")
    public String createStudent() {
        return "create-student";
    }

    @PostMapping("/create-student")
    public String createStudent(
            @ModelAttribute("student") Student student) {
        System.out.println(student.getName());
        //repository.save(student);
        return "redirect:/user-created";
    }

    @GetMapping("/user-created")
    public String userCreated() {
        return "user-created";
    }

    @GetMapping("/create-student-binding")
    public String createStudentBinding(Model model) {
        model.addAttribute("student", new Student());
        return "create-student-binding";
    }
}
