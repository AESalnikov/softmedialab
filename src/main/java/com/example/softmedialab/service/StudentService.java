package com.example.softmedialab.service;

import com.example.softmedialab.controller.model.Student;
import com.example.softmedialab.controller.request.MarksEditRequest;

import java.util.List;

/**
 * @author Anton Salnikov
 */
public interface StudentService {
    List<Student> getAllStudents();

    void addNewStudent(Student student);

    void deleteStudent(Long id);

    void editStudent(Student student);

    void editMarks(MarksEditRequest request);
}
