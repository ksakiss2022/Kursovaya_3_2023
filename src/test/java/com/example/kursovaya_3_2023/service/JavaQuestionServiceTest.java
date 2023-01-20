package com.example.kursovaya_3_2023.service;

import com.example.kursovaya_3_2023.exeption.BadRequestException;
import com.example.kursovaya_3_2023.model.Question;
import com.example.kursovaya_3_2023.repository.JavaQuestionRepository;
import com.example.kursovaya_3_2023.repository.QuestionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @InjectMocks
    private JavaQuestionService out;

    @Mock
    private QuestionRepository questionRepository;

    //    @BeforeEach
//    void setUp() {
//        out = new JavaQuestionService(questionRepository);
//    }
    @BeforeEach
    void setUp() {
        out = new JavaQuestionService(questionRepository);
        out.add(new Question("1 Question", "1 Ansver"));
        out.add(new Question("2 Question", "2 Ansver"));
        out.add(new Question("3 Question", "3 Ansver"));
        out.add(new Question("4 Question", "4 Ansver"));
        out.add(new Question("5 Question", "5 Ansver"));


    }

    @Test
    void addQuestion() throws BadRequestException {
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionRepository, Mockito.only()).add(expected);
    }

    @Test
    void testAdd() throws BadRequestException {
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected.getQuestion(), expected.getAnswer());
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionRepository, Mockito.only()).add(expected);
    }

    @Test
    void remove() throws BadRequestException {
        Question expected = new Question("Question", "Answer");
        Mockito.when(questionRepository.remove(any())).thenReturn(expected);
        Question actual = out.remove(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionRepository, Mockito.only()).remove(expected);
    }

    @Test
    void getAll() {
        Collection<Question> expected = List.of(new Question("Question", "Answer"));
        Mockito.when(questionRepository.getAll()).thenReturn(expected);
        Collection<Question> actual = out.getAll();
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionRepository, Mockito.only()).getAll();
    }

    @Test
    void getRandomQuestion() {
        Question expected = new Question("Question", "Answer");
        Collection<Question> expectedList = List.of(expected);
        Mockito.when(questionRepository.getAll()).thenReturn(expectedList);
        Question actual = out.getRandomQuestion();
        Assertions.assertThat(actual).isEqualTo(expected);
        Mockito.verify(questionRepository, Mockito.only()).getAll();

    }
}
