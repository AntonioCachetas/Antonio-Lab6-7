package org.humber.student.services.impl;

import lombok.NonNull;
import org.humber.student.domain.Country;
import org.humber.student.exceptions.ErrorCode;
import org.humber.student.exceptions.StudentValidationException;
import org.humber.student.services.StudentValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StudentNameValidation implements StudentValidationService {
    @Override
    public void validateStudent(@NonNull Country student) {
        if (student.getCountry() == null || !StringUtils.hasLength(student.getCountry().trim())) {
            System.err.println("Student name is null");
            throw new StudentValidationException(ErrorCode.INVALID_STUDENT_NAME);
        }
    }
}
