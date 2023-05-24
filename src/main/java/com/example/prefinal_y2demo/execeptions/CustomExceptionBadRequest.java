package com.example.prefinal_y2demo.execeptions;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CustomExceptionBadRequest extends RuntimeException {
    private List<ErrorResponse.ValidationError> ListError = new ArrayList<>();
    public CustomExceptionBadRequest(String message){
        super(message);
     }

     public void addListError(ErrorResponse.ValidationError filedError){
        ListError.add(filedError);
     }

}
