package com.example.prefinal_y2demo.execeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(CustomExceptionBadRequest.class)
 @ResponseStatus(HttpStatus.BAD_REQUEST)
 public ResponseEntity<ErrorResponse> handlerBadRequest (CustomExceptionBadRequest e,WebRequest request){
    ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),request.getDescription(false)) ;
    er.setErrors( e.getListError());
return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er) ;
}

    @ExceptionHandler(CustomExceptionNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handlerBadRequest (CustomExceptionNotFound e,WebRequest request){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),request.getDescription(false)) ;
        er.addValidationError(e.getMessage(), e.getFiled());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(er) ;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handlerBadRequest (RuntimeException e,WebRequest request){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),request.getDescription(false)) ;
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(er) ;
    }
    //    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorResponse>  handlerAuthentication(RuntimeException e){
//        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        ErrorResponse er = new ErrorResponse(LocalDateTime.now().format(formatter),HttpStatus.NOT_FOUND.value(),e.getMessage(), e.getMessage().getClass().getSimpleName());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er) ;
//    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleRequestParam(MethodArgumentNotValidException ex, WebRequest request) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
        fieldErrors.stream().forEach(x-> er.addValidationError(x.getField(),x.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er) ;
    }*/

}
