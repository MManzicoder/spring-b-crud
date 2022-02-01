package com.server.demo.student;

import javax.persistence.*;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String names;
    private String className;

    public Long getId() {
        return id;
    }

    public Student(Long id, String names, String className) {
        this.id = id;
        this.names = names;
        this.className = className;
    }

    public void setId( Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
//    public int generateId(){
//        int id = (int) Math.floor(Math.random()*100000000);
//        return id;
//    }
}
