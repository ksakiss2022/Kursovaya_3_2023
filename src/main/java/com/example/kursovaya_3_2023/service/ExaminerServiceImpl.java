package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.exeption.BadRequestException;
import com.example.kursovaya_3_2023.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionServices;

    public ExaminerServiceImpl(QuestionService questionServices) {
        this.questionServices = questionServices;
    }


    @Override
    public Collection<Question> getQuestions(int amount) throws BadRequestException {

        if (amount <= 0 || questionServices.getAll().size() < amount) {
            throw new BadRequestException("Нет такого количества вопросов" + amount);
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {

            result.add(questionServices.getRandomQuestion());

        }
        return result;
    }
}
