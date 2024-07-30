package net.hamdev.springBoot.controller;

import net.hamdev.springBoot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    //
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
    // spring Boot rest api with path Variable
    // {id} url template variable
    // http://localhost:8080/students/1/hamidie/ahmat

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable( @PathVariable("id") int studentID ,
            @PathVariable("first-name") String firstName,
           @PathVariable("last-name") String lastName){
        return new Student(studentID,firstName,lastName);
    }

    // Spring Boot Rest Api with request param
    // http://localhost:8080/students/query?id=1&firstName=hamidie&lastName=hissein
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                         @RequestParam String lastName){
        return new Student(id,firstName,lastName) ;

    }
    // spring boot REST API that handles HTTP Post Request
    // @PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }
}
