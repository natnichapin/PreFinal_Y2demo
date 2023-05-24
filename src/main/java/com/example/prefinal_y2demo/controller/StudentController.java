package com.example.prefinal_y2demo.controller;


import com.example.prefinal_y2demo.DTO.StudentRequestDTO;
import com.example.prefinal_y2demo.entity.Student;
import com.example.prefinal_y2demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService studentService;



    @GetMapping("")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.findStudentByID(id);
    }

    @PostMapping ("")
    public Student addStudent(@RequestBody StudentRequestDTO studentDTO){
        return studentService.AddStudent(studentDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id){
         studentService.DeleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id , @RequestBody StudentRequestDTO studentDTO){
        return studentService.updateStudent(id,studentDTO);
    }
}
