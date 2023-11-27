package com.quiz.impl;

import com.quiz.Services.QuestionClient;
import com.quiz.Services.QuizService;
import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionClient questionClient;


    @Override
    public Quiz add(Quiz quiz) {return quizRepository.save(quiz);}

    @Override
    public List<Quiz> getAll() {
       List<Quiz> quizzes=quizRepository.findAll();

        return quizzes.stream().map(quiz -> {
           quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
           return quiz;
       }).collect(Collectors.toList());
    }

    @Override
    public Quiz get(Long id) {
        Quiz quiz =quizRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));

        return quiz;
    }

    @Override
    public String deleteById(Long id) {
         quizRepository.deleteById(id);
         return "Quiz "+id+" deleted";
    }
}
