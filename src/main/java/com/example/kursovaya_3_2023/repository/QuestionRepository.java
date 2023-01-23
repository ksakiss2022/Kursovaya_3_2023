package com.example.kursovaya_3_2023.repository;

import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.exeption.BadRequestException;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question) throws BadRequestException;

    Question remove(Question question);

    Collection<Question> getAll();
}
