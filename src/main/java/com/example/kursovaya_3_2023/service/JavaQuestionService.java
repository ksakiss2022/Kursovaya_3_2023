package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.exeption.BadRequestException;
import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;
    private final Random random=new Random();

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) throws BadRequestException {
        if (question == null || question.isBlank()) {
            throw new BadRequestException("Вопрос не корректный");
        }
        if (answer == null || answer.isBlank()) {
            throw new BadRequestException("Вопрос не корректный");
        }
        return questionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return question;
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {

        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        int questionNum = random.nextInt(getAll().size());
        int questionCur = 0;
        for (Question question : getAll()) {
            if (questionCur == questionNum) {
                return question;
            }
            questionCur++;
        }
        return null;
    }
}
