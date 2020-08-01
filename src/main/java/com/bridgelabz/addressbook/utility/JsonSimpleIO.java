package com.bridgelabz.addressbook.utility;

import com.bridgelabz.addressbook.models.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonSimpleIO {
      List<Person> contactListOfPerson;

      public JsonSimpleIO(List<Person> contactListOfPerson) {
            this.contactListOfPerson = contactListOfPerson;
      }

      public void jsonFileWriter(String jsonFilePath) {
            JSONArray personList = new JSONArray();
            contactListOfPerson.forEach(person -> {
                  JSONObject personDetails = new JSONObject();
                  personDetails.put("First Name", person.firstName);
                  personDetails.put("Last Name", person.lastName);
                  personDetails.put("Address", person.address);
                  personDetails.put("City", person.cityName);
                  personDetails.put("State", person.stateName);
                  personDetails.put("Zipcode", person.zipCode);
                  personDetails.put("Mobile Number", person.mobileNumber);
                  JSONObject personObject = new JSONObject();
                  personObject.put("person", personDetails);
                  personList.add(personObject);
            });
            try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
                  fileWriter.append(personList.toJSONString());
                  fileWriter.flush();
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      public List<Person> jsonFileReader(String jsonFilePath) {
            JSONParser jsonParser = new JSONParser();
            try (FileReader fileReader = new FileReader(jsonFilePath)) {
                  Object obj = jsonParser.parse(fileReader);
                  JSONArray personList = (JSONArray) obj;
                  personList.forEach(person -> contactListOfPerson.add(parsePersonObject((JSONObject) person)));
            } catch (IOException | ParseException e) {
                  e.printStackTrace();
            }
            return contactListOfPerson;
      }

      private Person parsePersonObject(JSONObject jsonObject) {
            JSONObject personObj = (JSONObject) jsonObject.get("person");
            return new Person((String) personObj.get("First Name"),
                    (String) personObj.get("Last Name"),
                    (String) personObj.get("Address"),
                    (String) personObj.get("City"),
                    (String) personObj.get("State"),
                    Integer.parseInt(((Long) personObj.get("Zipcode")).toString()),
                    (Long) personObj.get("Mobile Number"));
      }
}
