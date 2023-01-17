package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.model.Random;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;
    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;

    }
    @Override
    public Collection<Question> getQuestions(int amount) throws BadRequestException {
        if (amount <= 0 || calculateAmountOfQuestions() < amount) {
            throw new BadRequestException("Вопрос не корректный" + amount);
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            int serviceNumber = random.getRandomInt(questionServices.size());
            var questionService = questionServices.get(serviceNumber);
            result.add((Question) questionService.getAll());

        }
        return result;
    }

    private int calculateAmountOfQuestions() {
        return questionServices.stream().mapToInt(s -> s.getAll().size()).sum();
    }
}
