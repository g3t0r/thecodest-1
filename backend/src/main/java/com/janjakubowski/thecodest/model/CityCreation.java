package com.janjakubowski.thecodest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CityCreation {

  private final Integer id;
  private final String name;
  private final String photo;
}
