package com.example.softmedialab.controller.response;

import com.example.softmedialab.controller.model.Student;
import lombok.Data;

import java.util.List;

/**
 * @author Anton Salnikov
 */
@Data
public class StudentGetAllResponse {

    private List<Student> students;

}
