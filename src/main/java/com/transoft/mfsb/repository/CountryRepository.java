package com.transoft.mfsb.repository;

import com.transoft.mfsb.domain.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
