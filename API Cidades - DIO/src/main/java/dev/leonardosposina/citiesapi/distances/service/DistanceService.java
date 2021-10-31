package dev.leonardosposina.citiesapi.distances.service;

import dev.leonardosposina.citiesapi.cities.entity.City;
import dev.leonardosposina.citiesapi.cities.repository.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    private final CityRepository cityRepository;

    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(Long city1, Long city2) {
        log.info("distanceByPoints({}, {})", city1, city2);
        return cityRepository.distanceByPoints(city1, city2);
    }

    public Double distanceByCubeInMeters(Long city1, Long city2) {
        final List<City> cities = cityRepository.findAllById(Arrays.asList(city1, city2));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        log.info("distanceByCube({}, {})", city1, city2);

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}
