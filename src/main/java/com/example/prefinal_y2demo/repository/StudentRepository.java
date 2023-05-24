package com.example.prefinal_y2demo.repository;

import com.example.prefinal_y2demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
