package com.helmes.cities.adapter.out.helper;

import com.helmes.cities.adapter.out.model.CityEntity;
import com.helmes.cities.adapter.out.persistance.MongoCityRepository;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

@RequiredArgsConstructor
public class CityCSVLoader {

  private final MongoCityRepository repository;

  public void loadCsv() {
    if (repository.count() > 0) return; // todo: create application property to load on demand (optional)

    Iterable<CSVRecord> csvRecords = null;
    final Path path = new File("src/main/resources/cities.csv").toPath();
    try ( InputStream targetStream = Files.newInputStream(path);
        BufferedReader fileReader = new BufferedReader(
            new InputStreamReader(targetStream, "UTF-8"))) {

      CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);

      csvRecords = csvParser.getRecords();
    } catch (IOException e) {
      // todo: log ex
    }

    for (CSVRecord csvRecord : csvRecords) {
      if (csvRecord.getRecordNumber() == 1) continue; // header
      CityEntity city = new CityEntity(
          csvRecord.get(0),
          csvRecord.get(1),
          csvRecord.get(2)
      );
      repository.save(city);

    }
  }
}
