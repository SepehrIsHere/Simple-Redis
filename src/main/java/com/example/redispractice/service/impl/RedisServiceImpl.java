package com.example.redispractice.service.impl;

import com.example.redispractice.entity.Student;
import com.example.redispractice.repository.RedisRepository;
import com.example.redispractice.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService {
    private final RedisRepository redisRepository;

    @Override
    public String save(String key, Student student) {
        redisRepository.save(student);
        return "entity saved with id : " + student.getId();
    }

    @Override
    public String update(String key, Student student) {
        redisRepository.save(student);
        return "entity updated with id : " + student.getId();
    }

    @Override
    public String delete(String key, Student student) {
        redisRepository.delete(student);
        return "entity saved with id : " + student.getId();

    }

    @Override
    public Student findById(Long id) {
        return redisRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));

    }

}
