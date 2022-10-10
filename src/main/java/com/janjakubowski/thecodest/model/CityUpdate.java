package com.janjakubowski.thecodest.model;

import java.util.Objects;

public class CityUpdate {
  private String name;
  private String photo;

  public CityUpdate(String name, String photo) {
    this.name = name;
    this.photo = photo;
  }

  public CityUpdate() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CityUpdate that = (CityUpdate) o;
    return Objects.equals(name, that.name) && Objects.equals(photo, that.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, photo);
  }
}
