package dev.leonardosposina.citiesapi.country.resource;

import dev.leonardosposina.citiesapi.country.entity.Country;
import dev.leonardosposina.citiesapi.country.repository.CountryRepository;
import dev.leonardosposina.citiesapi.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryResource {

    private final CountryRepository countryRepository;

    public CountryResource(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return countryRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public Country findById(@PathVariable Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, id));
    }

}
