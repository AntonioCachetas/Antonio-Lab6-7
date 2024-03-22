package org.humber.student.controllers;

import org.humber.student.domain.Country;
import org.humber.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Country> createStudent(@RequestBody Country student) {
        Country createdStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/{countryId}")
    public Country getStudent(@PathVariable Long countryId) {
        return studentService.getStudent(countryId);
    }

    @PutMapping("/{countryId}")
    public ResponseEntity<Country> updateStudent(@PathVariable Long countryId, @RequestBody Country student) {
        // Set the studentId from path variable
        student.setId(countryId);
        Country updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long countryId) {
        boolean deleted = studentService.deleteStudent(countryId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
