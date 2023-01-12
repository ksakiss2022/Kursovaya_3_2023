//package com.example.kursovaya_3_2023.service;
//
//import com.example.kursovaya_3_2023.model.Question;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.Set;
//
//@Service
//public class JavaQuestionService implements QuestionService {
//
//    Set<Question> questions;
//    @Override
//    public Question add(String question, String answer) throws BadRequestException {
//        if (question == null || question.isBlank() || question.isEmpty()) {
//            throw new BadRequestException("Вопрос не корректный");
//        }
//        if (answer == null || answer.isBlank() || answer.isEmpty()) {
//            throw new BadRequestException("Вопрос не корректный");
//        }
//        return add(new Question(question, answer));
//    }
//
//    @Override
//    public Question add(Question question) {
//        return add((question));
//    }
//
//    @Override
//    public Question remove(Question question) {
//        return remove(question);
//    }
//
//    @Override
//    public Collection<Question> getAll() {
//        return getAll();
//    }
//
//    @Override
//    public Question getRandomQuestion(Collection<Question> all) {
//        return getRandomQuestion(getAll());
//    }
//
//
//}
