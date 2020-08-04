package com.bridgelabz.addressbook.utility;

import com.bridgelabz.addressbook.models.Person;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GsonIO {

      public void writeToJsonWithGSON(String filePath, List<Person> contactList) {
            String personDetail = new Gson().toJson(contactList);
            try (FileWriter writer = new FileWriter(filePath)) {
                  writer.write(personDetail);
            } catch (NullPointerException | IOException e) {
                  e.printStackTrace();
            }
      }

      public void readFromJsonWithGSON(String filePath, List<Person> contactList) {
            try {
                  Person[] personDetails = new Gson().fromJson(new FileReader(filePath), Person[].class);
                  contactList.addAll(Arrays.asList(personDetails));
            } catch (FileNotFoundException e) {
                  e.printStackTrace();
            }
      }
}
