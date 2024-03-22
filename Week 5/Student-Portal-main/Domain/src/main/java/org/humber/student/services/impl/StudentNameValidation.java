package org.humber.student.services.impl;

import lombok.NonNull;
import org.humber.student.domain.Student;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.StudentValidationException;
import org.humber.student.services.StudentValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StudentNameValidation implements StudentValidationService {
    @Override
    public void validateStudent(@NonNull Student student) {
        if (student.getName() == null || !StringUtils.hasLength(student.getName().trim())) {
            System.err.println("Student name is null");
            throw new StudentValidationException(ErrorCode.INVALID_STUDENT_NAME);
        }
    }
}
