package com.spring.hibernatejpa.dao;

import com.spring.hibernatejpa.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student getById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);
}
