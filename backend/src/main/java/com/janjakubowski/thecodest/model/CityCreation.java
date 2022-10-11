package com.janjakubowski.thecodest.model;

import java.util.Objects;

public class CityCreation {
  private final Integer id;
  private final String name;
  private final String photo;

  public CityCreation(Integer id, String name, String photo) {
    this.id = id;
    this.name = name;
    this.photo = photo;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPhoto() {
    return photo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CityCreation that = (CityCreation) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name)
        && Objects.equals(photo, that.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, photo);
  }
}
