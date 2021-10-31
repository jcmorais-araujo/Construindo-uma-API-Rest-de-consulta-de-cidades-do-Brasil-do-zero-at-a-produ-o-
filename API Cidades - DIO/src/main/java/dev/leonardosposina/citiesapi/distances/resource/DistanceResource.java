package dev.leonardosposina.citiesapi.distances.resource;

import dev.leonardosposina.citiesapi.distances.service.DistanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/distance")
public class DistanceResource {

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService distanceService;

    public DistanceResource(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam (name = "from") final Long city1,
                           @RequestParam (name = "to") final Long city2) {
        log.info("byPoints endpoint call");
        return distanceService.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam (name = "from") final Long city1,
                           @RequestParam (name = "to") final Long city2) {
        log.info("byCube endpoint call");
        return distanceService.distanceByCubeInMeters(city1, city2);
    }
}
