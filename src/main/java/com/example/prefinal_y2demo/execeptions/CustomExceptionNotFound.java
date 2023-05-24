package com.example.prefinal_y2demo.execeptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomExceptionNotFound  extends RuntimeException {
    private String filed;


    public CustomExceptionNotFound (String message, String Field) {
        super(message);
        this.filed = Field;

    }


}
