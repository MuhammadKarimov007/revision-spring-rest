package dev.muhammad.restcrudapischapter4.rest;

import dev.muhammad.restcrudapischapter4.exceptions.StudentErrorResponse;
import dev.muhammad.restcrudapischapter4.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class StudentRestExceptionHandler {
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> studentErrorResponseResponseEntity(StudentNotFoundException studentNotFoundException) {
//        StudentErrorResponse response = new StudentErrorResponse();
//        response.setMessage(studentNotFoundException.getMessage());
//        response.setStatus(HttpStatus.NOT_FOUND.value());
//        response.setTimestamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> studentErrorResponseResponseEntity(MethodArgumentTypeMismatchException e) {
        StudentErrorResponse response = new StudentErrorResponse();
        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
