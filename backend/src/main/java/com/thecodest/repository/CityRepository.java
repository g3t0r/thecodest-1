package com.thecodest.repository;

import com.thecodest.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository  extends JpaRepository<City, Integer> {

  Page<City> findAll(Pageable pageable);
  Page<City> findByNameIgnoreCaseStartsWith(String name, Pageable pageable);

}
