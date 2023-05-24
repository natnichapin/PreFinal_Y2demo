package com.example.prefinal_y2demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentNumber", nullable = false)
    private Integer studentNumber ;
    @Column(name = "firstName", nullable = false)
    private String firstName ;
    @Column(name = "LastName", nullable = false)
    private String lastName ;
    @Column(name = "major", nullable = false)
    private String major ;

    @ManyToOne
    @JoinColumn(name = "subjectId" ,nullable = false)
    private Subject subjectId ;


}
