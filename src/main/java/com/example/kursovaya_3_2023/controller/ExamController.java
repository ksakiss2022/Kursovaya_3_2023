package com.example.kursovaya_3_2023.controller;

import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.exeption.BadRequestException;
import com.example.kursovaya_3_2023.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") Integer amount) throws BadRequestException {
        return examinerService.getQuestions(amount);
    }

}
