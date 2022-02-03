package com.server.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getStudents(){
        return this.studentService.getStudents();
    }
    @PostMapping
    public Message addStudent(@RequestBody Student body) throws Exception {
        return this.studentService.addStudent(body);
    }
    @GetMapping(path = "{id}")
    public Optional<Student> getStudent(@PathVariable("id") Long id){
        return this.studentService.getStudent(id);
    }
    @DeleteMapping(path = "{id}")
    public Message deleteStudent(@PathVariable("id") Long id){
        return this.studentService.deleteStudent(id);
    }
    @PutMapping(path = "{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student st){
        return this.studentService.updateStudent(id, st);

    }
}
