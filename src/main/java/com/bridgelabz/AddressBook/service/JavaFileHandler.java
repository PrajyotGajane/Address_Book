package com.bridgelabz.AddressBook.service;

import com.bridgelabz.AddressBook.models.Person;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JavaFileHandler {
      public JavaFileHandler(List<Person> contactsDetailsList) {
            try (FileWriter writer = new FileWriter("JsonWithJava.json");) {
                  for (Person str : contactsDetailsList) {
                        writer.write(str + System.lineSeparator());
                  }
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }
}
