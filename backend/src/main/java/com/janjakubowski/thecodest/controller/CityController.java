package com.janjakubowski.thecodest.controller;

import com.janjakubowski.thecodest.model.City;
import com.janjakubowski.thecodest.model.CityUpdate;
import com.janjakubowski.thecodest.service.CityService;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/cities")
@RestController
public class CityController {

  private final CityService cityService;

  public CityController(CityService cityService) {
    this.cityService = cityService;
  }

  @GetMapping
  public Page<City> getCities(
      @RequestParam Optional<String> search,
      Pageable pageable
  ) {
    return cityService.getCities(search, pageable);
  }

  @PatchMapping("{id}")
  public City patchCity(
      @PathVariable Integer id,
      @RequestBody CityUpdate patch) {
    return cityService.patchCity(id, patch);
  }

  @PutMapping("{id}")
  public City replaceCity(
      @PathVariable Integer id,
      @RequestBody CityUpdate replacement) {
    return cityService.replaceCity(id, replacement);
  }

}
