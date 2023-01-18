package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    public Set<Question> questions;

    public JavaQuestionService() {

    }

    @Override
    public Question add(String question, String answer) throws BadRequestException {
        if (question == null || question.isBlank() || question.isEmpty()) {
            throw new BadRequestException("Вопрос не корректный");
        }
        if (answer == null || answer.isBlank() || answer.isEmpty()) {
            throw new BadRequestException("Вопрос не корректный");
        }
        // return add(new Question(question, answer));
        return new Question(question, answer);
    }

    @Override
    public Question add(Question question) {

        //return add((question));
        return question;
    }

    @Override
    public Question remove(Question question) {
        // return remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {

        return questions;
    }

    //    @Override
//    public Question getRandomQuestion(Collection<Question> all) {
//        return getRandomQuestion(getAll());
//    }
    public static int getRandomInt(int maxQuestion) {
        return maxQuestion;
    }

    public  Question getRandomQuestion(Collection<Question> questions) {
        int quetionNum = getRandomInt(questions.size());
        int questionCur = 0;
        for (Question question : questions) {
            if (questionCur == quetionNum) {
                return question;
            }
            questionCur++;
        }
        return null;
    }

    @Override
    public Object getRandomQuestion() {
        return getRandomQuestion();
    }

//    public void setRandom(Random random) {
//        this.random = random;
//    }
//

//
//
//    private Random nextInt(int maxQuetion) {
//        return random;
//    }
//
//
//    public Question getRandomQuestion(Collection<Question> questions) {
//        int quetionNum = getRandomInt(questions.size());
//        int questionCur = 0;
//        for (Question question : questions) {
//            if (questionCur == quetionNum) {
//                return question;
//            }
//            questionCur++;
//        }
//        return null;
//    }

}
