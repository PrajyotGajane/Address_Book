package com.bridgelabz.AddressBook.service;
import com.bridgelabz.AddressBook.models.Person;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class AddressBook {
      /**
       * to add details to Person class
       * @return object of Person class
       */
      public static void addContact(List<Person> arrayReference, HashMap<String, String> mapCity, HashMap<String, String> mapState) {
            Scanner sc = new Scanner(System.in);
            boolean flag = true;
            boolean validString = false;
            try {
                  System.out.println("Enter the first name:");
                  String firstName = sc.nextLine();
                  validString = AddressBook.stringChecker(firstName);
                  if (validString) {
                        validString = false;
                        System.out.println("Enter the last name:");
                        String lastName = sc.nextLine();
                        validString = AddressBook.stringChecker(lastName);
                        if (validString) {
                              String firstLastName = firstName + lastName;
                              for (Person person : arrayReference) {
                                    if (firstLastName.equals(person.getRecord() + person.getLastName())) {
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
                                    arrayReference.add(new Person(firstName, lastName, address, cityName, stateName, zipCode, mobileNumber));
                                    mapCity.put(firstName,cityName);
                                    mapState.put(firstName,stateName);
                              }
                        } else{
                              System.out.println("Enter valid last name");
                        }
                  } else{
                        System.out.println("Enter valid first name");
                  }
            } catch (InputMismatchException e) {
                  System.out.println("Enter valid data");
            }
      }
      /**
       * to check if the string is entirely made up of characters and not integers
       * @param checkString
       * @return validString
       */
      public static boolean stringChecker(String checkString){
            Pattern stringChecker = Pattern.compile("([a-zA-Z]+)");
            Matcher matchString = stringChecker.matcher(checkString);
            boolean validString = matchString.matches();
            return validString;
      }
      /**
       * to sort the contacts as user wishes
       * @param arrayReference
       */
      public static void sortContact(List<Person> arrayReference){
            Scanner sc = new Scanner(System.in);
            System.out.println("Press 1: Sort by Name 2: Sort by city 3: Sort by State 4: Sort by zip code");
            int choice_2 = sc.nextInt();
            switch (choice_2){
                  case 1:
                        List<Person> sortedList = arrayReference.stream()
                                .sorted(Comparator.comparing(Person::getRecord))
                                .collect(Collectors.toList());
                        sortedList.forEach(System.out::println);
                        break;
                  case 2:
                        List<Person> sortedListCity = arrayReference.stream()
                                .sorted(Comparator.comparing(Person::getCityName))
                                .collect(Collectors.toList());
                        sortedListCity.forEach(System.out::println);
                        break;
                  case 3:
                        List<Person> sortedListState = arrayReference.stream()
                                .sorted(Comparator.comparing(Person::getStateName))
                                .collect(Collectors.toList());
                        sortedListState.forEach(System.out::println);
                        break;
                  case 4:
                        List<Person> sortedListZip = arrayReference.stream()
                                .sorted(Comparator.comparing(Person::getZipCode))
                                .collect(Collectors.toList());
                        sortedListZip.forEach(System.out::println);
                        break;
                  default:
                        System.out.println("Enter valid input");
                        break;
            }
            //AddressBookFunction.displayAll(arrayReference);
      }
      /**
       * to display all contacts
       * @param arrayReference
       */
      public static void displayAll(List<Person> arrayReference){
            arrayReference.stream().forEach(System.out::println);
      }
      public static void viewContacts(List<Person> arrayReference, HashMap<String,String> mapCity, HashMap<String,String> mapState){
            Scanner sc = new Scanner(System.in);
            System.out.println("1: All contacts 2: By city 3:By state");
            int choice3 = sc.nextInt();
            switch (choice3){
                  case 1:
                        //to view all contents of the address book
                        AddressBook.displayAll(arrayReference);
                        break;
                  case 2:
                        //to view people and their cities
                        for (Iterator iterator = mapCity.entrySet().iterator(); iterator.hasNext();) {
                              Map.Entry e = (Map.Entry) iterator.next();
                              // prints all the people in map with their corresponding cities
                              System.out.println(e.getKey()+" from "+e.getValue());
                        }
                        break;
                  case 3:
                        //to view people and their states
                        for (Iterator iterator = mapState.entrySet().iterator(); iterator.hasNext();) {
                              Map.Entry e = (Map.Entry) iterator.next();
                              // prints all the people in map with their corresponding states
                              System.out.println(e.getKey()+" from "+e.getValue());
                        }
                        break;
                  default:
                        System.out.println("Invalid input");
                        break;
            }
      }
      /**
       * to search for people of particular city or state
       * @param mapCity
       * @param mapState
       */
      public static void customPlace(HashMap<String,String> mapCity,HashMap<String,String> mapState) {
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
                                    Map.Entry e = (Map.Entry) iterator.next();
                                    if (search.equals(e.getValue())) {
                                          // view all the people from user given city in string 'search'
                                          System.out.println(" " + e.getKey());
                                    }
                              }
                              break;
                        case 2:
                              sc.nextLine();
                              System.out.println("Enter the name of the state you want to view people from");
                              String searchState = sc.nextLine();
                              System.out.println("People in " + searchState + " are");
                              for (Iterator iterator = mapState.entrySet().iterator(); iterator.hasNext(); ) {
                                    Map.Entry e = (Map.Entry) iterator.next();
                                    if (searchState.equals(e.getValue())) {
                                          // view all the people from user given state in string 'searchState'
                                          System.out.println(" " + e.getKey());
                                    }
                              }
                              break;
                        default:
                              System.out.println("Invalid input");
                              break;
                  }
            } catch (InputMismatchException e){
                  System.out.println("Enter valid option");
            }
      }
      /**
       * to delete contacts
       * @param arrayReference
       */
      public static void deleteContact(List<Person> arrayReference) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            System.out.println("Enter the first name of the contact to be deleted");
            String delete = sc.nextLine();
            for (ListIterator<Person> iterator = arrayReference.listIterator(); iterator.hasNext(); ) {
                  Person data = iterator.next();
                  if (delete.equals(data.getRecord())) {
                        iterator.remove();
                  }
            }
            System.out.println("Contact deleted");
            AddressBook.displayAll(arrayReference);
      }
      /**
       * edit details of contacts
       * @param arrayReference
       */
      public static void editContactDetails(List<Person> arrayReference) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Edit information ");
            System.out.println("Enter the first name of the person you would like to edit details about");
            String update = sc.nextLine();
            for (ListIterator<Person> iter = arrayReference.listIterator(); iter.hasNext(); ) {
                  Person data = iter.next();
                  if (update.equals(data.getRecord())) {
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
            AddressBook.displayAll(arrayReference);
      }
}