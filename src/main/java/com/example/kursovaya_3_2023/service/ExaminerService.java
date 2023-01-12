package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws BadRequestException;
}
