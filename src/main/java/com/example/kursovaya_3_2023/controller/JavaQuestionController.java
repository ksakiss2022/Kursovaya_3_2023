package com.example.kursovaya_3_2023.controller;

import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.exeption.BadRequestException;
import com.example.kursovaya_3_2023.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService javaQuetionService) {
        this.questionService = javaQuetionService;
    }

    @GetMapping("/add")
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }


    @GetMapping("/add1")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) throws BadRequestException {
        return questionService.add(question, answer);
    }


    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
