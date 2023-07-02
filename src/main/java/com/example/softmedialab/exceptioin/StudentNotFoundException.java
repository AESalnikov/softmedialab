package com.example.softmedialab.exceptioin;

/**
 * @author Anton Salnikov
 */
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }

}
