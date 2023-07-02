package com.example.softmedialab.repository;

import com.example.softmedialab.dto.StudentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Anton Salnikov
 */
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
