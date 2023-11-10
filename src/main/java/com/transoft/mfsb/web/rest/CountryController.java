package com.transoft.mfsb.web.rest;

import com.transoft.mfsb.domain.entity.Country;
import com.transoft.mfsb.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public ResponseEntity<List<Country>> getCountries() {
        return ResponseEntity.ok().body(countryService.listCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable final Integer id) {
        return ResponseEntity
                .ok(countryService.getCountryById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Country with " +id+ " is not existed")));
    }

    @PostMapping
    public ResponseEntity<Country> saveCountry(@RequestBody final Country country) throws URISyntaxException {
        if (country.getId() != null) {
            throw new IllegalArgumentException("A new Country cannot already have a id");
        }

        Country countryFromDB = countryService.save(country);
        return ResponseEntity.created(new URI("/v1/countries/" +countryFromDB.getId())).body(countryFromDB);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> editCountry(@RequestBody final Country country,
                                               @PathVariable final Integer id) throws URISyntaxException {
        if (country.getId() == null) {
            throw new IllegalArgumentException("Invalid Country id, null value not allowed");
        }

        if (!Objects.equals(id, country.getId())) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity.ok().body(countryService.edit(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable final Integer id) {
        countryService.delete(id);
        return ResponseEntity.ok().build();
    }
}
