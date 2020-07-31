package com.bridgelabz.AddressBook.controller;

import com.bridgelabz.AddressBook.models.Person;
import com.bridgelabz.AddressBook.service.AddressBook;

import java.util.*;

public class AddressBookMain {
      public static void main(String[] args) {
            List<Person> contactsDetailsList = new ArrayList<>();
            HashMap<String, String> mapCity = new HashMap<>();
            HashMap<String, String> mapState = new HashMap<>();
            Scanner sc = new Scanner(System.in);
            boolean endKey = true;
            System.out.println("Welcome to Address book");
            System.out.println("Select options from the menu");
            contactsDetailsList.add(new Person("Prajyot", "Gaj", "Hno 4", "Gogol", "Gta", 23232, 345345345));
            while (endKey) {
                  System.out.println("1.Add  2.Edit  3.Delete  4.View  5:Sort  6:Search  7:Create Output Files    9:EXIT");
                  int choice = sc.nextInt();
                  switch (choice) {
                        case 1:
                              AddressBook.addContact(contactsDetailsList, mapCity, mapState);
                              break;
                        case 2:
                              AddressBook.editContactDetails(contactsDetailsList);
                              break;
                        case 3:
                              AddressBook.deleteContact(contactsDetailsList);
                              break;
                        case 4:
                              AddressBook.viewContacts(contactsDetailsList, mapCity, mapState);
                              break;
                        case 5:
                              AddressBook.sortContact(contactsDetailsList);
                              contactsDetailsList.stream().forEach(System.out::println);
                              break;
                        case 6:
                              AddressBook.customPlace(mapCity, mapState);
                              break;
                        case 7:
                              AddressBook.writeToJson();
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
}