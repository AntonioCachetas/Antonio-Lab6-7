package org.humber.student.services.impl;

import lombok.NonNull;
import org.humber.student.domain.Country;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.StudentValidationException;
import org.humber.student.services.StudentValidationService;
import org.springframework.stereotype.Component;

@Component
public class StudentIdValidation implements StudentValidationService {
    @Override
    public void validateStudent(@NonNull Country student) {
        if(student.getId() == null) {
            System.err.println("Student id is null");
            throw new StudentValidationException(ErrorCode.INVALID_STUDENT_ID);
        }
    }
}
