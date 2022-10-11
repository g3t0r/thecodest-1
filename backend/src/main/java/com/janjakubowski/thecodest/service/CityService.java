package com.janjakubowski.thecodest.service;

import com.janjakubowski.thecodest.model.City;
import com.janjakubowski.thecodest.model.CityCreation;
import com.janjakubowski.thecodest.model.CityUpdate;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {

  Page<City> getCities(Optional<String> name, Pageable pageable);

  City replaceCity(Integer id, CityUpdate replacement);

  City patchCity(Integer id, CityUpdate patchCityDTO);

  City createCity(CityCreation city);

  long getCityCount();

  City getById(Integer id);
}
