package org.humber.student.services;

import org.humber.student.domain.Country;

import java.util.List;

public interface StudentJPAService {

    Country getStudentById(Long studentId);

    List<Country> getAllStudents();

    Country saveStudent(Country student);

}
