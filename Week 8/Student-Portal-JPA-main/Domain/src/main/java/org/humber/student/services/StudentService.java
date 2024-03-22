package org.humber.student.services;

import org.humber.student.domain.Country;

public interface StudentService {

    Country createStudent(Country student);

    boolean deleteStudent(Long studentId);

    Country updateStudent(Country student);

    Country getStudent(Long studentId);

}
