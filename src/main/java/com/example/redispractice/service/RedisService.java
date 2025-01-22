package com.example.redispractice.service;

import com.example.redispractice.entity.Student;

public interface RedisService {
    String save(String key, Student student);

    String update(String key, Student student);

    String delete(String key, Student student);

    Student findById(Long id);
}
