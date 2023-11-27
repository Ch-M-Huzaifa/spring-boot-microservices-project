package com.question.service;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question create(Question question);

    List<Question> getAll();

    Question getBYId(Long id);

    List<Question> getQuestionOfQuiz(Long quizId);
}
