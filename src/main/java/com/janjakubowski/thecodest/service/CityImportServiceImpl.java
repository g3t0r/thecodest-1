package com.janjakubowski.thecodest.service;

import com.janjakubowski.thecodest.exception.CsvImportException;
import com.janjakubowski.thecodest.model.CityCreation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CityImportServiceImpl implements
    CityImportService {

  static final int ID = 0;
  static final int NAME = 1;
  static final int PHOTO = 2;

  private final String filePath;

  private final CityService cityService;

  public CityImportServiceImpl(@Value("${cities.import.file}") String filePath,
      CityService cityService) {
    this.filePath = filePath;
    this.cityService = cityService;
  }

  @Override
  public void importCities() {

    if(isImportAlreadyDone()) {
      return;
    }

    File file = new File(filePath);

    try {

      BufferedReader reader = new BufferedReader(new FileReader(file));

      String line;
      reader.readLine(); // skipping header

      while((line = reader.readLine()) != null) {
        cityService.createCity(mapToCity(line));
      }

    } catch (IOException e) {
      throw CsvImportException.fromException(e);
    }
  }

  private CityCreation mapToCity(String line) {

    String[] separated = line.split(",");
    if(separated.length != 3) {
      throw CsvImportException.incorrectColumnNumber(separated.length);
    }
    return new CityCreation(
        Integer.valueOf(separated[ID]),
        separated[NAME],
        separated[PHOTO]
    );
  }

  private boolean isImportAlreadyDone() {
    return cityService.getCityCount() > 0;
  }
}
