package com.example.springfoundation;

import com.example.springfoundation.dao.StudentRepository;
import com.example.springfoundation.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void shouldSaveUserInDatabase() {
        studentRepository.save(new Student("Nika", "nika@gmail.com"));
        List<Student> users = studentRepository.findAll();
        assertEquals(1, users.size());
    }
}
