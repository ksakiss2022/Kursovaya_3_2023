package com.example.kursovaya_3_2023.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class Random {

    private Random random;

    @Autowired
    public void setRandom(Random random) {
        this.random = random;
    }

    public int getRandomInt(int maxQuetion) {
        return maxQuetion;
    }


    private Random nextInt(int maxQuetion) {
        return random;
    }


    public Question getRandomQuestion(Collection<Question> questions) {
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


}
