package com.spring.hibernatejpa.dao;

import com.spring.hibernatejpa.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student getById(int id);
}
