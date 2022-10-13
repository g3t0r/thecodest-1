package com.thecodest.service;

import com.thecodest.model.City;
import com.thecodest.model.CityCreation;
import com.thecodest.model.CityUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

  Page<City> getCities(String name, Pageable pageable);

  Page<City> getCities(Pageable pageable);

  City replaceCity(Integer id, CityUpdate replacement);

  City patchCity(Integer id, CityUpdate patchCityDTO);

  City createCity(CityCreation city);

  long getCityCount();

  City getById(Integer id);
}
