package com.thecodest.service;

import com.thecodest.exception.EntityNotFoundException;
import com.thecodest.exception.ValidationException;
import com.thecodest.model.City;
import com.thecodest.model.CityCreation;
import com.thecodest.model.CityUpdate;
import com.thecodest.repository.CityRepository;
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
  public Page<City> getCities(String name, Pageable pageable) {
      return cityRepository.findByNameIgnoreCaseStartsWith(name, pageable);
  }

  @Override
  public Page<City> getCities(Pageable pageable) {
    return cityRepository.findAll(pageable);
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
