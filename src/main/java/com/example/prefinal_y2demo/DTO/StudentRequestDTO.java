package com.example.prefinal_y2demo.DTO;

import com.example.prefinal_y2demo.entity.Subject;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDTO {
    private String firstName ;
    private String lastName ;
    private String major ;
    private Integer subjectId ;

}
