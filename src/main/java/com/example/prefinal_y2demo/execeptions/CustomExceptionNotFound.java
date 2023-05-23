package com.example.prefinal_y2demo.execeptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExceptionNotFound  extends RuntimeException {
    private String errorField;


    public CustomExceptionNotFound (String message, String Field) {
        super(message);
        this.errorField = Field;

    }


}
