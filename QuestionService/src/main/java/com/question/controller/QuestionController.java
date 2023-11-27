package com.question.controller;

import com.question.entities.Question;
import com.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/save")
    public Question create(@RequestBody Question question){
        return questionService.create(question);
    }

    @GetMapping("/getAll")
    public List<Question> getAll(){
        return questionService.getAll();
    }

    @GetMapping("/get/{id}")
    public Question getById(@PathVariable Long id){
        return questionService.getBYId(id);
    }

    //get all questions of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId){
        return questionService.getQuestionOfQuiz(quizId);
    }

}
