package org.humber.student.transformers;

import org.humber.student.domain.Country;
import org.humber.student.repositories.entities.StudentEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class StudentEntityTransformer {

    private StudentEntityTransformer() {
    }

    public static StudentEntity transformToStudentEntity(Country student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setCountry(student.getCountry());
        studentEntity.setCapital(student.getCapital());
        studentEntity.setPopulation(student.getPopulation());
        studentEntity.setArea(student.getArea());
        studentEntity.setLanguage(student.getLanguage());
        return studentEntity;
    }

    //private static void setAddress(Student student, StudentEntity studentEntity) {
      //  if (student.getAddress() == null) {
        //    return;
        //}
        //studentEntity.setStreet(student.getAddress().getStreet());
        //studentEntity.setCity(student.getAddress().getCity());
        //studentEntity.setProvince(student.getAddress().getProvince());
        //studentEntity.setPostalCode(student.getAddress().getPostalCode());
        //studentEntity.setCountry(student.getAddress().getCountry());
    //}

    public static Country transformToStudent(StudentEntity studentEntity) {
        return Country.builder()
                .Id(studentEntity.getId())
                .country(studentEntity.getCountry())
                .capital(studentEntity.getCapital())
                .population(studentEntity.getPopulation())
                .area(studentEntity.getArea())
                .language(studentEntity.getLanguage())
                .build();
    }

    //private static Address transformToAddress(StudentEntity studentEntity) {
      //  return Address.builder()
        //        .street(studentEntity.getStreet())
          //      .city(studentEntity.getCity())
            //    .province(studentEntity.getProvince())
              //  .postalCode(studentEntity.getPostalCode())
               // .country(studentEntity.getCountry())
              //  .build();
    //}

    public static List<Country> transformToStudents(List<StudentEntity> entities) {
        return entities.stream()
                .map(StudentEntityTransformer::transformToStudent)
                .collect(Collectors.toList());
    }
}
