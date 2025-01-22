package com.example.redispractice.service;

import com.example.redispractice.entity.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student update(Student student);

    void deleteById(Long id);

    void delete(Student student);

    List<Student> findAll();

}
