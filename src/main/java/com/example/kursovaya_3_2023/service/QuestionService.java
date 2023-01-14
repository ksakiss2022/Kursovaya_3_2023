package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer) throws BadRequestException;

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion(Collection<Question> all);

    Object getRandomQuestion();
}
