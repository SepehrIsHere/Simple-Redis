package com.example.redispractice.repository;

import com.example.redispractice.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<Student, Long> {

}
