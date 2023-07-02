package com.example.softmedialab.util;

import com.example.softmedialab.controller.model.Student;
import com.example.softmedialab.dto.StudentEntity;
import lombok.experimental.UtilityClass;

/**
 * @author Anton Salnikov
 */
@UtilityClass
public class StudentUtil {

    public static Student convertFromStudentEntityToStudent(StudentEntity entity) {
        return Student.builder()
                .id(entity.getId())
                .fio(entity.getFio())
                .birthday(entity.getBirthday())
                .mark(entity.getMark())
                .build();
    }

    public static StudentEntity convertFromStudentToStudentEntity(Student model) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(model.getId());
        studentEntity.setFio(model.getFio());
        studentEntity.setBirthday(model.getBirthday());
        studentEntity.setMark(model.getMark());
        return studentEntity;
    }

}
