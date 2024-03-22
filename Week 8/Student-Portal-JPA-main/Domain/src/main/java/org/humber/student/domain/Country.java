package org.humber.student.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Long Id;
    private String country;
    private String capital;
    private Integer population;
    private Integer area;
    private String language;
}
