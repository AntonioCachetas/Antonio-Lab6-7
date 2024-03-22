
package com.example.demo.controller.com.example;

/**
 *
 * @author antoniocachetas
 */
public class Student {
    
      private String name;
    private String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }
    
}
