package org.humber.student.repositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "country")
    private String country;

    @Column(name = "capital")
    private String capital;

    @Column(name = "population")
    private Integer population;

    @Column(name = "area")
    private Integer area;

    @Column(name = "language")
    private String language;


}
