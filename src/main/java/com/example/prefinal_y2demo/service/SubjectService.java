package com.example.prefinal_y2demo.service;

import com.example.prefinal_y2demo.entity.Subject;
import com.example.prefinal_y2demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository ;

    public List<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    public Subject addSubject(Subject subject){
        return subjectRepository.saveAndFlush(subject);
    }

}
