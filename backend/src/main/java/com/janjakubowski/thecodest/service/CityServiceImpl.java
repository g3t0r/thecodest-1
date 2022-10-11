package com.janjakubowski.thecodest.service;

import com.janjakubowski.thecodest.exception.EntityNotFoundException;
import com.janjakubowski.thecodest.exception.ValidationException;
import com.janjakubowski.thecodest.model.City;
import com.janjakubowski.thecodest.model.CityCreation;
import com.janjakubowski.thecodest.model.CityUpdate;
import com.janjakubowski.thecodest.repository.CityRepository;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

  private final CityRepository cityRepository;

  public CityServiceImpl(CityRepository cityRepository) {
    this.cityRepository = cityRepository;
  }

  @Override
  public Page<City> getCities(Optional<String> name, Pageable pageable) {
    if(name.isPresent()) {
      return cityRepository.findByNameIgnoreCaseStartsWith(name.get(), pageable);
    } else {
      return cityRepository.findAll(pageable);
    }
  }

  @Override
  public City replaceCity(Integer id, CityUpdate replacement) {
    City city = getCityOrThrow(id);

    if(replacement.getName() == null || replacement.getName().isEmpty()) {
      throw new ValidationException("Name can't be null or empty");
    }

    if(replacement.getPhoto() == null || replacement.getPhoto().isEmpty()) {
      throw new ValidationException("Photo can't be null or empty");
    }

    city.setName(replacement.getName());
    city.setPhoto(replacement.getPhoto());

    return cityRepository.save(city);
  }

  @Override
  public City patchCity(Integer id, CityUpdate patchCityDTO) {
    City city = getCityOrThrow(id);

    if(patchCityDTO.getName() != null) {
      city.setName(patchCityDTO.getName());
    }

    if(patchCityDTO.getPhoto() != null) {
      city.setPhoto(patchCityDTO.getPhoto());
    }

    return cityRepository.save(city);
  }

  @Override
  public City createCity(CityCreation creation) {
    return cityRepository.save(
        new City(
            creation.getId(),
            creation.getName(),
            creation.getPhoto()
        )
    );
  }

  @Override
  public long getCityCount() {
    return cityRepository.count();
  }

  @Override
  public City getById(Integer id) {
    return getCityOrThrow(id);
  }

  City getCityOrThrow(Integer id) {
    return cityRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id));
  }
}
