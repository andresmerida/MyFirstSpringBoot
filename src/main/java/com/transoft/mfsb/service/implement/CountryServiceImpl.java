package com.transoft.mfsb.service.implement;

import com.transoft.mfsb.domain.entity.Country;
import com.transoft.mfsb.repository.CountryRepository;
import com.transoft.mfsb.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Integer id) {
        return countryRepository.findById(id);
    }
}
