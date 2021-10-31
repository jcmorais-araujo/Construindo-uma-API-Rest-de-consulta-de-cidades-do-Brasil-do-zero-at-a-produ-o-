package dev.leonardosposina.citiesapi.states.repository;

import dev.leonardosposina.citiesapi.states.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
