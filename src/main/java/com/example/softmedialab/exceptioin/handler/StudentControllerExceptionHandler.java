package com.example.softmedialab.exceptioin.handler;

import com.example.softmedialab.controller.model.ErrorMessage;
import com.example.softmedialab.exceptioin.StudentAlreadyExistException;
import com.example.softmedialab.exceptioin.StudentNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anton Salnikov
 */
@RestControllerAdvice
public class StudentControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(
                ErrorMessage.builder().messages(
                        exception.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                .collect(Collectors.toList())
                ).build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(StudentAlreadyExistException.class)
    public ResponseEntity<ErrorMessage> studentAlreadyExistExceptionHandler(StudentAlreadyExistException exception) {
        return new ResponseEntity<>(ErrorMessage.builder().messages(List.of(exception.getMessage())).build(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> studentNotFoundExceptionHandler(StudentNotFoundException exception) {
        return new ResponseEntity<>(ErrorMessage.builder().messages(List.of(exception.getMessage())).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> studentNotFoundExceptionHandler(Exception exception) {
        return new ResponseEntity<>(ErrorMessage.builder().messages(List.of("Произошла непредвиденная ошибка: " + exception.getMessage())).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
