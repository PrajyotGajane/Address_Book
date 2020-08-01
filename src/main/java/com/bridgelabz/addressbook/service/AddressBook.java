package com.bridgelabz.addressbook.service;


import com.bridgelabz.addressbook.models.Person;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressBook {
      List<Person> contactsDetailsList;

      public AddressBook(List<Person> contactsDetailsList) {
            this.contactsDetailsList = contactsDetailsList;
      }

      public void addContact(HashMap<String, String> mapCity, HashMap<String, String> mapState) {
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            boolean validString;
            try {
                  System.out.println("Enter the first name:");
                  String firstName = sc.nextLine();
                  validString = stringChecker(firstName);
                  if (validString) {
                        System.out.println("Enter the last name:");
                        String lastName = sc.nextLine();
                        validString = stringChecker(lastName);
                        if (validString) {
                              String firstLastName = firstName + lastName;
                              for (Person person : contactsDetailsList) {
                                    if (firstLastName.equals(person.getFirstName() + person.getLastName())) {
                                          System.out.println("Contact already exists");
                                          flag = false;
                                    }
                              }
                              if (flag) {
                                    System.out.println("Enter your address:");
                                    String address = sc.nextLine();
                                    System.out.println("Enter the City name:");
                                    String cityName = sc.nextLine();
                                    System.out.println("Enter the State name:");
                                    String stateName = sc.nextLine();
                                    System.out.println("Enter the zip code:");
                                    int zipCode = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Enter the mobile number:");
                                    long mobileNumber = sc.nextLong();
                                    contactsDetailsList.add(new Person(firstName, lastName, address, cityName, stateName, zipCode, mobileNumber));
                                    mapCity.put(firstName, cityName);
                                    mapState.put(firstName, stateName);
                              }
                        } else {
                              System.out.println("Enter valid last name");
                        }
                  } else {
                        System.out.println("Enter valid first name");
                  }
            } catch (InputMismatchException e) {
                  System.out.println("Enter valid data");
            }
      }

      private boolean stringChecker(String checkString) {
            Pattern stringChecker = Pattern.compile("([a-zA-Z]+)");
            Matcher matchString = stringChecker.matcher(checkString);
            boolean validString = matchString.matches();
            return validString;
      }

      public void editContactDetails(List<Person> contactsDetailsList) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Edit information ");
            System.out.println("Enter the name of the person you would like to edit details about");
            String update = sc.nextLine();
            for (ListIterator<Person> listIterator = contactsDetailsList.listIterator(); listIterator.hasNext(); ) {
                  Person data = listIterator.next();
                  if (update.equals(data.getName())) {
                        System.out.println("Update 1: Address 2:City 3:State 4:Zip code 5: Mobile Number");
                        int choice_2 = sc.nextInt();
                        switch (choice_2) {
                              case 1:
                                    sc.nextLine();
                                    System.out.println("Update new address:");
                                    data.address = sc.nextLine();
                                    break;
                              case 2:
                                    sc.nextLine();
                                    System.out.println("Update the city:");
                                    data.cityName = sc.nextLine();
                                    break;
                              case 3:
                                    sc.nextLine();
                                    System.out.println("Update the state");
                                    data.stateName = sc.nextLine();
                                    break;
                              case 4:
                                    sc.nextLine();
                                    System.out.println("Update the mobile zip code");
                                    data.zipCode = sc.nextInt();
                                    sc.nextLine();
                                    break;
                              case 5:
                                    sc.nextLine();
                                    System.out.println("Update the mobile number");
                                    data.mobileNumber = sc.nextLong();
                              default:
                                    System.out.println("Enter valid input");
                                    break;
                        }
                        System.out.println("Contact updated");
                  }
            }
            displayAll(contactsDetailsList);
      }

      private static void displayAll(List<Person> contactsDetailsList) {
            contactsDetailsList.stream().forEach(System.out::println);
      }

      public void deleteContact() {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            System.out.println("Enter the name of the contact to be deleted");
            String delete = sc.nextLine();
            for (ListIterator<Person> iterator = contactsDetailsList.listIterator(); iterator.hasNext(); ) {
                  Person data = iterator.next();
                  if (delete.equals(data.getName())) {
                        iterator.remove();
                  }
            }
            System.out.println("Contact deleted");
            displayAll(contactsDetailsList);
      }

      public void viewContacts(HashMap<String, String> mapCity, HashMap<String, String> mapState) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1: All contacts 2: By city 3:By state");
            int choice3 = sc.nextInt();
            switch (choice3) {
                  case 1:
                        displayAll(contactsDetailsList);
                        break;
                  case 2:
                        //to view people and their cities
                        for (Iterator iterator = mapCity.entrySet().iterator(); iterator.hasNext(); ) {
                              Map.Entry cities = (Map.Entry) iterator.next();
                              // prints all the people in map with their corresponding cities
                              System.out.println(cities.getKey() + " from " + cities.getValue());
                        }
//                        contactsDetailsList.sort(Comparator.comparing(personCity -> personCity.cityName));
//                        contactsDetailsList.forEach(s -> System.out.println(s.getCityName().c));
                        break;
                  case 3:
                        //to view people and their states
                        for (Map.Entry<String, String> stringStringEntry : mapState.entrySet()) {
                              Map.Entry states = stringStringEntry;
                              // prints all the people in map with their corresponding states
                              System.out.println(states.getKey() + " from " + states.getValue());
                        }
                        break;
                  default:
                        System.out.println("Invalid input");
                        break;
            }
      }

      public void sortContact() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Press 1: Sort by Name 2: Sort by city 3: Sort by State 4: Sort by zip code");
            int choice_2 = sc.nextInt();
            sc.nextLine();
            switch (choice_2) {
                  case 1:
                        contactsDetailsList.sort(Comparator.comparing(personName -> personName.firstName));
                        contactsDetailsList.forEach(System.out::println);
                        break;
                  case 2:
                        contactsDetailsList.sort(Comparator.comparing(personCity -> personCity.cityName));
                        contactsDetailsList.forEach(System.out::println);
                        break;
                  case 3:
                        contactsDetailsList.sort(Comparator.comparing(personState -> personState.stateName));
                        contactsDetailsList.forEach(System.out::println);
                        break;
                  case 4:
                        contactsDetailsList.sort(Comparator.comparing(personZipCode -> personZipCode.zipCode));
                        contactsDetailsList.forEach(System.out::println);
                        break;
                  default:
                        System.out.println("Enter valid input");
                        break;
            }
      }

      public void customPlace(HashMap<String, String> mapCity, HashMap<String, String> mapState) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Search people");
            System.out.println("1:By city    2:By state");
            try {
                  int choiceFour = sc.nextInt();
                  switch (choiceFour) {
                        case 1:
                              sc.nextLine();
                              System.out.println("Enter the name of the city you want to view people from");
                              String search = sc.nextLine();
                              System.out.println("People in " + search + " are");
                              for (Iterator iterator = mapCity.entrySet().iterator(); iterator.hasNext(); ) {
                                    Map.Entry cities = (Map.Entry) iterator.next();
                                    if (search.equals(cities.getValue())) {
                                          // view all the people from user given city in string 'search'
                                          System.out.println(" " + cities.getKey());
                                    }
                              }
                              break;
                        case 2:
                              sc.nextLine();
                              System.out.println("Enter the name of the state you want to view people from");
                              String searchState = sc.nextLine();
                              System.out.println("People in " + searchState + " are");
                              for (Iterator iterator = mapState.entrySet().iterator(); iterator.hasNext(); ) {
                                    Map.Entry states = (Map.Entry) iterator.next();
                                    if (searchState.equals(states.getValue())) {
                                          // view all the people from user given state in string 'searchState'
                                          System.out.println(" " + states.getKey());
                                    }
                              }
                              break;
                        default:
                              System.out.println("Invalid input");
                              break;
                  }
            } catch (InputMismatchException e) {
                  System.out.println("Enter valid option");
            }
      }
}
