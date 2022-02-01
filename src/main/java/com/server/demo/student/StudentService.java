package com.server.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    public ArrayList<Student> students = new ArrayList<>();
    public Student first = new Student(1L, "James Hirwa", "Year1");
    StudentService(){
        students.add(first);
    }
    public List<Student> getStudents(){
        return this.students;
    }
    public Message addStudent(Student student){
        this.students.add(student);
        return new Message("added student");
    }
    public Message deleteStudent(int id){
        for(Student s: students){
            if(s.getId() == id)
                this.students.remove(s);
                 return new Message("Deleted student");
        }
        return null;
    }
    public Student getStudent(int id){
        for(Student s: this.students){
            if(s.getId() == id)
                return s;
        }
        return null;
    }
    public Student updateStudent(int id, Student st){
        for(Student s: students){
            if(s.getId() == id)
                 s.setNames(st.getNames());
                 s.setClassName(st.getClassName());
                 return s;
        }
        return null;
    }
}

class Message{
    public String message;
    public Message(String message){
        this.message = message;
    }
}