package com.spring.hibernatejpa;

import com.spring.hibernatejpa.dao.StudentDAO;
import com.spring.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatejpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernatejpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //this.createStudent(studentDAO);
            this.getStudentById(studentDAO, 1);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student object...");
        Student student = new Student("Paul", "McCarthy", "jl@gmail.com");

        System.out.println("Saving the student...");
        studentDAO.save(student);

        System.out.println("Saved student. Generated Id: " + student.getId());
    }

    private void getStudentById(StudentDAO studentDAO, int id) {
        System.out.println("student: ");
        try {
            Student student = studentDAO.getById(id);
            System.out.println(student.toString());
        } catch (NullPointerException e) {
            System.out.println("No student found");
        }
    }
}
