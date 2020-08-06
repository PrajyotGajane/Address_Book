package com.bridgelabz.addressbook.service;


import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.utility.GsonIO;
import com.bridgelabz.addressbook.utility.JsonSimpleIO;
import com.bridgelabz.addressbook.utility.OpenCSVIO;
import com.bridgelabz.addressbook.utility.UserInputs;

import java.util.*;

public class AddressBook extends Thread {
      private final List<Person> contactsDetailsList = new ArrayList<>();

      public boolean isContactPresent(Person personContact) {
            return contactsDetailsList.stream().anyMatch(person -> person == personContact);
      }

      public void addContact(Person personDetails) {
            contactsDetailsList.add(personDetails);
      }


      public void editContactDetails(String firstName, String lastName) {
            Person personDetails = findPersonObject(firstName, lastName);
            if (personDetails != null) {
                  addContact(new UserInputs().addDetails(personDetails));
                  contactsDetailsList.remove(personDetails);
            } else
                  System.out.println("Record does not exist");
      }

      public void displayAll() {
            contactsDetailsList.forEach(System.out::println);
      }

      public void deleteContact(String firstName, String lastName) {
            Person personDetails = findPersonObject(firstName, lastName);
            if (personDetails != null)
                  contactsDetailsList.remove(personDetails);
            else
                  System.out.println("Record does not exist");
            System.out.println("Contact deleted");
            displayAll();
      }

      public void sortContact(int choice_2) {
            switch (choice_2) {
                  case 1:
                        contactsDetailsList.sort(Comparator.comparing(personName -> personName.firstName));
                        break;
                  case 2:
                        contactsDetailsList.sort(Comparator.comparing(personCity -> personCity.cityName));
                        break;
                  case 3:
                        contactsDetailsList.sort(Comparator.comparing(personState -> personState.stateName));
                        break;
                  case 4:
                        contactsDetailsList.sort(Comparator.comparing(personZipCode -> personZipCode.zipCode));
                        break;
                  default:
                        System.out.println("Enter valid input");
                        break;
            }
            contactsDetailsList.forEach(System.out::println);
      }

      public void searchPerson(String firstName, String lastName) {
            Person personDetails = findPersonObject(firstName, lastName);
            if (personDetails != null)
                  System.out.println(personDetails.toString());
            else
                  System.out.println("Record does not exist");
      }

      public Person findPersonObject(String firstName, String lastName) {
            return contactsDetailsList.stream()
                    .filter(details -> details.getFirstName().equals(firstName) && details.getLastName().equals(lastName))
                    .findFirst().orElse(null);
      }

      public void saveGSONType(GsonIO gsonIO, String address_book_file_path_gson, int choice) {
            switch (choice) {
                  case 1:
                        gsonIO.readFromJsonWithGSON(address_book_file_path_gson, contactsDetailsList);
                        break;
                  case 2:
                        gsonIO.writeToJsonWithGSON(address_book_file_path_gson, contactsDetailsList);
                        break;
                  default:
                        System.out.println("Choose valid input");
                        break;
            }
      }

      public void saveCSVType(OpenCSVIO openCSVIO, String address_book_file_path_csv, int choice) {
            switch (choice) {
                  case 1:
                        openCSVIO.readFromCSVFile(address_book_file_path_csv, contactsDetailsList);
                        break;
                  case 2:
                        openCSVIO.writeToCSVFile(address_book_file_path_csv, contactsDetailsList);
                        break;
                  default:
                        System.out.println("Choose valid input");
                        break;
            }
      }

      public void saveJsonType(JsonSimpleIO jsonSimpleIO, String filePath) {
            System.out.println("Choose operation for json file");
            Scanner scanner = new Scanner(System.in);
            boolean endKey = true;
            while (endKey) {
                  System.out.println("1: JSON Read    2: JSON Write     9: Exit");
                  int choice;
                  choice = scanner.nextInt();
                  scanner.nextLine();
                  switch (choice) {
                        case 1:
                              jsonSimpleIO.jsonFileReader(filePath, contactsDetailsList);
                              break;
                        case 2:
                              jsonSimpleIO.jsonFileWriter(filePath, contactsDetailsList);
                              break;
                        case 9:
                              endKey = false;
                              break;
                        default:
                              System.out.println("Choose valid input");
                              break;
                  }
            }
      }
      public List<Person> getContactsDetailsList(){
            return contactsDetailsList;
      }
}
