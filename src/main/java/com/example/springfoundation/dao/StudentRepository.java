package com.example.springfoundation.dao;

import com.example.springfoundation.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
