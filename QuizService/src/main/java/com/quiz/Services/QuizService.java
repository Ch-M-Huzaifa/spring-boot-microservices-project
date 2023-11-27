package com.quiz.Services;

import com.quiz.entities.Quiz;

import java.util.List;

public interface QuizService {
    Quiz add(Quiz quiz);

    List<Quiz> getAll();

    Quiz get(Long id);

    String deleteById(Long id);
}
