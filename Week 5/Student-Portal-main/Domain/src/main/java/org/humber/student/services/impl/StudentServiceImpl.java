package org.humber.student.services.impl;

import org.humber.student.domain.Student;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.StudentValidationException;
import org.humber.student.services.StudentJPAService;
import org.humber.student.services.StudentService;
import org.humber.student.services.StudentValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentJPAService studentJpaService;
    private final List<StudentValidationService> validationServices;

    @Autowired
    public StudentServiceImpl(StudentJPAService studentJpaService, List<StudentValidationService> validationService) {
        this.studentJpaService = studentJpaService;
        this.validationServices = validationService;
    }

    @Override
    public Student createStudent(Student student) {
        System.out.println("In method createStudent, validating student= " + student.toString());
        for (StudentValidationService validationService : validationServices) {
            if (validationService instanceof StudentIdValidation) {
                System.out.println("Skipping StudentIdValidation for new Student");
                continue;
            }
            validationService.validateStudent(student);
        }
        System.out.println("Saving student");
        return studentJpaService.saveStudent(student);
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        System.out.println("Deleting student");
        Student student = studentJpaService.getStudentById(studentId);
        return student != null;
    }

    @Override
    public Student updateStudent(Student student) {
        //TODO: Implement update student
        System.out.println("Updating student");
        return null;
    }

    @Override
    public Student getStudent(Long studentId) {
        System.out.println("Getting student");
        if(studentId == null) {
            System.err.println("Student id is null");
            throw new StudentValidationException(ErrorCode.INVALID_STUDENT_ID);
        }
        return studentJpaService.getStudentById(studentId);
    }
}
