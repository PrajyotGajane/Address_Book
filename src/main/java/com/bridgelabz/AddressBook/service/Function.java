package com.bridgelabz.AddressBook.service;
import com.bridgelabz.AddressBook.main.*;
import com.bridgelabz.AddressBook.Utility.Person;

import java.util.ListIterator;
import java.util.*;

public class Function {
      public static Person addContact() {
            addressBook ob =  new addressBook();

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the first name:");
            String firstName = sc.nextLine();
            System.out.println("Enter the last name:");
            String lastName = sc.nextLine();
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

            return new Person(firstName, lastName, address, cityName, stateName, zipCode, mobileNumber);
      }
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
            for(Person content : arrayReference)
                  System.out.println(content);
      }
}
