package dev.leonardosposina.citiesapi.states.resource;

import dev.leonardosposina.citiesapi.exception.ResourceNotFoundException;
import dev.leonardosposina.citiesapi.states.entity.State;
import dev.leonardosposina.citiesapi.states.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/states")
public class StateResource {

    private final StateRepository stateRepository;

    public StateResource(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public Page<State> states(Pageable page) {
        return stateRepository.findAll(page);
    }

    @GetMapping("/{id}")
    public State findById(@PathVariable Long id) {
        return stateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(State.class, id));
    }
}
