package com.janjakubowski.thecodest.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "city")
public class City {
  @Id
  private Integer id;

  private String name;
  @Column(length = 1000)

  private String photo;


  public City(Integer id, String name, String photo) {
    this.id = id;
    this.name = name;
    this.photo = photo;
  }

  protected City() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
    City city = (City) o;
    return id.equals(city.id) && name.equals(city.name) && photo.equals(city.photo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, photo);
  }
}
