package com.example.prefinal_y2demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjectId", nullable = false)
    private Integer subjectId ;
    @Column(name = "subjectName", nullable = false)
    private String subjectName ;
    @Column(name = "descriptionSubject", nullable = false)
    private String descriptionSubject ;




}


