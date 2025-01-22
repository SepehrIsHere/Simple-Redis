package com.example.redispractice.repository.impl;

import com.example.redispractice.dto.StudentDto;
import com.example.redispractice.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
@RequiredArgsConstructor
public class StudentRedisRepositoryImpl {
    private final RedisTemplate<String, Student> redisTemplate;
    private final ValueOperations<String, Student> valueOperations;
    private AtomicLong atomicLong = new AtomicLong(0);

    Student save(Student student) {
        valueOperations.set(updateKey(atomicLong), student);
        return student;
    }

    Student update(String key, StudentDto studentDto) {
        Student student = findByKey(key);
        return updateStudentFields(student, studentDto);
    }


    Student findByKey(String key) {
        Student student = valueOperations.get(key);
        if (student != null) {
            return student;
        } else {
            throw new NullPointerException("Student not found");
        }
    }

    String deleteByKey(String key) {
        redisTemplate.delete(key);
        return "Deleted entity with key : " + key;
    }

    private String updateKey(AtomicLong atomicLong) {
        return "student" + atomicLong.incrementAndGet();
    }

    private Student updateStudentFields(Student student, StudentDto studentDto) {
        if (!student.getFullName().equals(studentDto.getFullName())) {
            student.setFullName(studentDto.getFullName());
        } else if (student.getAge() != studentDto.getAge()) {
            student.setAge(studentDto.getAge());
        }
        return student;
    }
}
