package com.server.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
   private final StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents(){
       return this.studentRepository.findAll();
    }
    public Message addStudent(Student student){
        this.studentRepository.save(student);
        return new Message("added student ");
    }
    public Message deleteStudent(Long id){
     return new Message("deleted student");
    }
    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
      }
    public Student updateStudent(Long id, Student st){
//        Student std = studentRepository.findById(id);
//        std.setNames(std.getNames());
//        return std;
        return st;
      }
}

class Message{
    public String message;
    public Message(String message){
        this.message = message;
    }
}