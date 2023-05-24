package com.example.prefinal_y2demo.controller;

import com.example.prefinal_y2demo.entity.Subject;
import com.example.prefinal_y2demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService ;

    @GetMapping("")
    public List<Subject> getSubjects(){
        return subjectService.getSubjects();
    }

    @PostMapping("")
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }
}
