package dev.leonardosposina.citiesapi.country.repository;

import dev.leonardosposina.citiesapi.country.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}