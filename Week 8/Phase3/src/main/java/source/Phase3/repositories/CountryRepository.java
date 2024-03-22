/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source.Phase3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import source.Phase3.Country;

public interface CountryRepository extends JpaRepository<Country, String> {
}

