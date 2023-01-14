package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.model.Random;
import org.assertj.core.util.diff.myers.MyersDiff;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl out;
    @Mock
    QuestionService questionService;
    @Mock
    Random random;

    @BeforeEach
    void setUp() {
        out = new ExaminerServiceImpl(List.of(questionService));

    }

//    @Test
//    void getQuestionsCorrectAmount() throws BadRequestException {
//        Question expected = new Question("Question", "Answer");
//        Collection<Question> expectedList = Set.of(expected);
//        Mockito.when(random.getRandomInt(anyInt())).thenReturn(0);
//        Mockito.when(questionService.getRandomQuestion()).thenReturn(expected);
//        Mockito.when(questionService.getAll()).thenReturn(expectedList);
//        Collection<Question> actualList = out.getQuestions(1);
//        Assertions.assertThat(actualList).isEqtualTo(expectedList);
//        Mockito.verify(questionService, Mockito.times(1)).getAll();
//        Mockito.verify(questionService, Mockito.times(1)).getRandomQuestion();
//        Mockito.verify(random, Mockito.times(1)).getRandomInt(anyInt());
//
//    }
}