package com.example.kursovaya_3_2023.repository;

import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.exeption.BadRequestException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init() {
        questions.add(new Question("1 Question.", "1 Answer"));
        questions.add(new Question("2 Question.", "2 Answer"));
        questions.add(new Question("3 Question.", "3 Answer"));
        questions.add(new Question("4 Question.", "4 Answer"));
        questions.add(new Question("5 Question.", "5 Answer"));
    }

    @Override
    public Question add(Question question) throws BadRequestException {
        if (question == null) {
            throw new BadRequestException("Необходимо добавить вопрос");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
