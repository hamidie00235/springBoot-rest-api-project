package net.hamdev.springBoot.controller;

import net.hamdev.springBoot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student

    @GetMapping("student")
    public Student getStudent(){
        Student student =new Student(
                1,
                "hamidie",
                "ahmat"
        );
                return student;
    }
    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students =new ArrayList<>();
        students.add(new Student(1,"Rozi","mht"));
        students.add(new Student(2,"hamidie","ahmat"));
        students.add(new Student(3,"omar","yusuf"));
        students.add(new Student(4,"yakup","bachar"));
        return students;
    }
}
