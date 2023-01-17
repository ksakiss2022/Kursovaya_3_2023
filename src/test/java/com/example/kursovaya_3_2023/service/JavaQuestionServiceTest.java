package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.model.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService out;

    @Mock
    private QuestionService questionService;
    @Mock
    private Random random;

    @BeforeEach
    void setUp() {
        out = new JavaQuestionService(questionService);
    }

    @Test
    void addQuetion() {
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionService.add(any())).thenReturn(expected);
        Question actual = out.add(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionService, Mockito.only()).add(expected);
    }

    @Test
    void testAdd() throws BadRequestException {
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionService.add(any())).thenReturn(expected);
        Question actual = out.add(expected.getQuestion(), expected.getAnswer());
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionService, Mockito.only()).add(expected);
    }

    @Test
    void remove() {
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionService.remove(any())).thenReturn(expected);
        Question actual = out.remove(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionService, Mockito.only()).add(expected);
    }

    @Test
    void getAll() {
        Collection<Question> expected = List.of(new Question("Question", "Answer"));
        Mockito.when(questionService.getAll()).thenReturn(expected);
        Collection<Question> actual = out.getAll();
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionService, Mockito.only()).getAll();
    }

    @Test
    void getRandomQuestion() {
        Question expected = new Question("Question", "Answer");
        Collection<Question> expectedList = List.of(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedList);
        Mockito.when(random.getRandomQuestion(expectedList)).thenReturn(expected);
        Question actual = (Question) out.getRandomQuestion();
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionService, Mockito.only()).getAll();
        Mockito.verify(random, Mockito.only()).getRandomQuestion(expectedList);
    }

    @Test
    void testGetRandomQuestion() {
        Question expected = new Question("Question", "Answer");
        Collection<Question> expectedList = List.of(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedList);
        Mockito.when(random.getRandomQuestion(expectedList)).thenReturn(expected);
        Question actual = (Question) out.getRandomQuestion();
        Answer actualAnswer=(Answer) out.getRandomQuestion();
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(actualAnswer).isEqualTo(expected);
        Mockito.verify(questionService, Mockito.only()).getAll();
        Mockito.verify(random, Mockito.only()).getRandomQuestion(expectedList);
    }
}
