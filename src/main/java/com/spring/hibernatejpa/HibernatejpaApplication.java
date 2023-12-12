package com.spring.hibernatejpa;

import com.spring.hibernatejpa.dao.StudentDAO;
import com.spring.hibernatejpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatejpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernatejpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // this.createStudent(studentDAO);
            // this.getStudentById(studentDAO, 1);
            // this.getAllStudents(studentDAO);
            // this.getByLastName(studentDAO, "Lemon");
            this.updateStudent(studentDAO);
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

    private void getAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for (Student student: students) {
            System.out.println(student);
        }
    }

    private void getByLastName(StudentDAO studentDAO, String lastName) {
        try {
            List<Student> students = studentDAO.findByLastName(lastName);
            System.out.println(students);
            for (Student student: students) {
                System.out.println(student);
            }
        } catch (NullPointerException e){
            System.out.println("No student found!");
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.getById(1);

        System.out.println("Updating student...");
        student.setFirstName("Updated");
        studentDAO.update(student);

        System.out.println("Updated student" + student);
    }
}
