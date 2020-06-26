package com.bridgelabz.AddressBook.service;
import com.bridgelabz.AddressBook.utility.Person;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Function {
      /**
       * to add details to Person class
       * @return object of Person class
       */
      public static void addContact(ArrayList<Person> arrayReference, HashMap<String, String> mapCity, HashMap<String, String> mapState) {
            Scanner sc = new Scanner(System.in);
            int flag = 0;
            boolean validString = false;
            try {
                  System.out.println("Enter the first name:");
                  String firstName = sc.nextLine();
                  validString = Function.stringChecker(firstName);
                  if (validString) {
                        validString = false;
                        System.out.println("Enter the last name:");
                        String lastName = sc.nextLine();
                        validString = Function.stringChecker(lastName);
                        if (validString) {
                              String firstLastName = firstName + lastName;
                              for (Person person : arrayReference) {
                                    System.out.println("in for loop");
                                    if (firstLastName.equals(person.getRecord() + person.getLastName())) {
                                          System.out.println("Contact already exists");
                                          flag = 1;
                                    }
                              }
                              if (flag == 0) {
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

            } catch (NullPointerException | InputMismatchException e) {
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
      public static void sortContact(ArrayList<Person> arrayReference){
            Scanner sc = new Scanner(System.in);

            System.out.println("Press 1: Sort by Name 2: Sort by city 3: Sort by State 4: Sort by zip code");
            int choice_2 = sc.nextInt();
            switch (choice_2){
                  case 1:
                        Collections.sort(arrayReference,new Comparator<Person>(){
                              public int compare(Person obj1,Person obj2){
                                    return obj2.firstName.compareTo(obj1.firstName);
                              }
                        }.reversed());//to show in ascending order
                        break;
                  case 2:
                        Collections.sort(arrayReference,new Comparator<Person>(){
                              public int compare(Person obj1,Person obj2){
                                    return obj2.cityName.compareTo(obj1.cityName);
                              }
                        }.reversed());//to show in ascending order
                        break;
                  case 3:
                        Collections.sort(arrayReference,new Comparator<Person>(){
                              public int compare(Person obj1,Person obj2){
                                    return obj2.stateName.compareTo(obj1.stateName);
                              }
                        }.reversed());//to show in ascending order
                        break;
                  case 4:
                        Collections.sort(arrayReference,new Comparator<Person>(){
                              public int compare(Person obj1,Person obj2){
                                    return obj2.zipCode - obj1.zipCode;
                              }
                        }.reversed());//to show in ascending order
                        break;
                  default:
                        System.out.println("Enter valid input");
                        break;
            }
            Function.displayAll(arrayReference);
      }
      /**
       * to display all contacts
       * @param arrayReference
       */
      public static void displayAll(ArrayList<Person> arrayReference){
            arrayReference.stream().forEach(System.out::println);
      }
      public static void viewContacts(ArrayList<Person> arrayReference, HashMap<String,String> mapCity, HashMap<String,String> mapState){
            Scanner sc = new Scanner(System.in);
            System.out.println("1: All contacts 2: By city 3:By state");
            int choice3 = sc.nextInt();
            switch (choice3){
                  case 1:
                        //to view all contents of the address book
                        Function.displayAll(arrayReference);
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
                        for (Iterator iter = mapState.entrySet().iterator(); iter.hasNext();) {
                              Map.Entry e = (Map.Entry) iter.next();
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
      public static void deleteContact(ArrayList<Person> arrayReference) {
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
            System.out.println("Enter the first name of the contact to be deleted");
            String delete = sc.nextLine();
            for (ListIterator<Person> iter = arrayReference.listIterator(); iter.hasNext(); ) {
                  Person data = iter.next();
                  if (delete.equals(data.getRecord())) {
                        iter.remove();
                  }
            }
            System.out.println("Contact deleted");
            Function.displayAll(arrayReference);
      }
      /**
       * edit details of contacts
       * @param arrayReference
       */
      public static void editContactDetails(ArrayList<Person> arrayReference) {
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
            Function.displayAll(arrayReference);
      }
}