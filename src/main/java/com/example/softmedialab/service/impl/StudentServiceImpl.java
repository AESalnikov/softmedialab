package com.example.softmedialab.service.impl;

import com.example.softmedialab.controller.model.Student;
import com.example.softmedialab.controller.request.MarksEditRequest;
import com.example.softmedialab.dto.StudentEntity;
import com.example.softmedialab.exceptioin.StudentAlreadyExistException;
import com.example.softmedialab.exceptioin.StudentNotFoundException;
import com.example.softmedialab.repository.StudentRepository;
import com.example.softmedialab.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.softmedialab.util.StudentUtil.convertFromStudentEntityToStudent;
import static com.example.softmedialab.util.StudentUtil.convertFromStudentToStudentEntity;

/**
 * @author Anton Salnikov
 */
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        repository.findAll().forEach(entity -> students.add(convertFromStudentEntityToStudent(entity)));
        return students;
    }

    @Override
    public void addNewStudent(Student student) {
        if (repository.findById(student.getId()).isPresent()) {
            throw new StudentAlreadyExistException("Студент уже существует!");
        }
        repository.save(convertFromStudentToStudentEntity(student));
    }

    @Override
    public void deleteStudent(Long id) {
        repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Студент не найден!"));
        repository.deleteById(id);
    }

    @Override
    public void editStudent(Student student) {
        StudentEntity studentEntity = repository.findById(student.getId()).orElseThrow(() -> new StudentNotFoundException("Студент не найден!"));
        studentEntity.setFio(student.getFio() != null ? student.getFio() : studentEntity.getFio());
        studentEntity.setBirthday(student.getBirthday() != null ? student.getBirthday() : studentEntity.getBirthday());
        studentEntity.setMark(student.getMark() != null ? student.getMark() : studentEntity.getMark());
        repository.save(studentEntity);
    }

    @Override
    public void editMarks(MarksEditRequest request) {
        request.getMarks().forEach(markEdit ->
                repository.findById(markEdit.getId())
                        .ifPresent(student -> {
                            student.setMark(markEdit.getMark());
                            repository.save(student);
                        }));
    }

}
