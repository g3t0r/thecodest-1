package com.thecodest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

  @Id
  private Integer id;

  private String name;
  @Column(length = 1000)

  private String photo;

}
