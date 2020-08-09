package ahlev.location;
/*
 * User: ohahlev@gmail.com
 * Project: api
 * Date: 8/9/20
 * Here is some description
 */

import java.util.List;
import org.junit.Test;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import ahlev.location.controller.LocationController;
import ahlev.location.domain.Country;
import ahlev.location.service.LocationService;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.isA;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
public class LocationControllerTest {

    @Autowired
    private MockMvc mockedMvc;

    @MockBean
    LocationService locationService;

    @Test
    public void getCountries_shouldReturnCountries() throws Exception {

        Country country = new Country("Cambodia");
        List<Country> countries = new ArrayList<Country>();
        countries.add(country);

        when(locationService.getCountries()).thenReturn(countries);

        mockedMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", isA(ArrayList.class)))
                .andExpect(jsonPath("$.*", hasSize(1)));
    }

}
