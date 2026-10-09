package com.example.kitapapi.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//hataları merkezi olarak yönetiyor
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)//cevap 404 yapıyor
    public String handleproductNotFound(ProductNotFoundException ex){
        return ex.getMessage();
    }



}
