package com.server.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Message addStudent(@RequestBody Student body){
        return this.studentService.addStudent(body);
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return this.studentService.getStudent(id);
    }
    @DeleteMapping("/students/:id")
    public Message deleteStudent(@PathVariable int id){
        return this.studentService.deleteStudent(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student st){
        return this.studentService.updateStudent(id, st);

    }
}
