package com.example.vitekpirate.repository;

import com.example.vitekpirate.entity.Group;
import com.example.vitekpirate.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class GroupRepositoryTest {

    @Autowired
    GroupRepository repository;

    @Test
    void saveGroup() {

        // given
        Group group = new Group();
        List<Student> students = new ArrayList<>();
        LocalDate date;

        group.setId(1);
        group.setName("IT404");
        group.setStudents(students);

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Mike");
        student1.setSurname("Lebowski");
        student1.setRegistrationDate(LocalDate.now());
        student1.setGroup(group);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("John");
        student2.setSurname("Smith");
        student2.setRegistrationDate(LocalDate.now());
        student2.setGroup(group);

        repository.save(group);

        // when
        boolean expected = repository.existsById(1);

        // then
        assertTrue(expected);
    }
}