package com.quiz.controller;

import com.quiz.Services.QuizService;
import com.quiz.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;


    @PostMapping("/save")
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    @GetMapping("/getAll")
    public List<Quiz> getAll(){
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public Quiz getById(@PathVariable long id){
        return quizService.get(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){return quizService.deleteById(id);}
}
