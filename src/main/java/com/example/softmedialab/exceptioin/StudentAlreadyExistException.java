package com.example.softmedialab.exceptioin;

/**
 * @author Anton Salnikov
 */
public class StudentAlreadyExistException extends RuntimeException {

    public StudentAlreadyExistException(String message) {
        super(message);
    }

}
