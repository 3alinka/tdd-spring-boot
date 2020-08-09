package ahlev.location.controller;
/*
 * User: ohahlev@gmail.com
 * Project: api
 * Date: 8/9/20
 * Here is some description
 */

import java.util.List;
import java.util.ArrayList;
import ahlev.location.domain.Country;
import ahlev.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @GetMapping("/countries")
    private List<Country> getCountries() {
        return locationService.getCountries();
    }
}
