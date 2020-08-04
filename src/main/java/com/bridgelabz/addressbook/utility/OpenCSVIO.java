package com.bridgelabz.addressbook.utility;

import com.bridgelabz.addressbook.models.Person;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVIO {
      public void writeToCSVFile(String filePath, List<Person> contactList) {
            try (Writer writer = Files.newBufferedWriter(Paths.get(filePath))) {
                  StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                          .build();
                  beanToCsv.write(contactList);
            } catch (IOException | CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                  e.printStackTrace();
            }
      }

      public List<Person> readFromCSVFile(String filePath, List<Person> contactList) {
            try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
                  csvReader.readNext();
                  String[] field;
                  while ((field = csvReader.readNext()) != null) {
                        contactList.add(new Person(field[2], field[3], field[0], field[1], field[5], field[6], field[4]));
                  }
            } catch (IOException e) {
                  e.printStackTrace();
            }
            return contactList;
      }
}
