package net.hamdev.springBoot.controller;

import net.hamdev.springBoot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student

    @GetMapping("student")
    public ResponseEntity<Student >getStudent(){
        Student student =new Student(
                1,
                "hamidie",
                "ahmat"
        );
                //return new ResponseEntity<>(student,HttpStatus.OK);
    return ResponseEntity.ok().
            header("Custorm-header","hamidie").
            body(student);
    }
    //
    // http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>>  getStudents(){
        List<Student> students =new ArrayList<>();
        students.add(new Student(1,"Rozi","mht"));
        students.add(new Student(2,"hamidie","ahmat"));
        students.add(new Student(3,"omar","yusuf"));
        students.add(new Student(4,"yakup","bachar"));

        return ResponseEntity.ok(students);
    }
    // spring Boot rest api with path Variable
    // {id} url template variable
    // http://localhost:8080/students/1/hamidie/ahmat

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student >studentPathVariable( @PathVariable("id") int studentID ,
            @PathVariable("first-name") String firstName,
           @PathVariable("last-name") String lastName){
  Student student= new Student(studentID,firstName,lastName);
  return ResponseEntity.ok(student);
    }

    // Spring Boot Rest Api with request param
    // http://localhost:8080/students/query?id=1&firstName=hamidie&lastName=hissein
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                         @RequestParam String lastName){
      Student student = new Student(id,firstName,lastName) ;
      return ResponseEntity.ok(student);

    }
    // spring boot REST API that handles HTTP Post Request

    // @PostMapping and @RequestBody (to bin json to java objet)

    // http://localhost:8080/students/create
    @PostMapping("students/create")
    //@ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity <Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    // spring boot REST API that handles http put request -updating existing resource
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updatingStudent(@RequestBody Student student,@PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student) ;
    }
    // Spring boot REST API that handles HTTP Delete request -deleting the existing resource
    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deletingStudent(@PathVariable ("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }
}
