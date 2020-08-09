package ahlev.location.service;
/*
 * User: ohahlev@gmail.com
 * Project: api
 * Date: 8/9/20
 * Here is some description
 */

import ahlev.location.domain.Country;
import ahlev.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Country> getCountries() {
        return locationRepository.findAll();
    }
}
