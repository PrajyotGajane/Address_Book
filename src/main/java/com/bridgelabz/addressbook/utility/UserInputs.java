package com.bridgelabz.addressbook.utility;

import com.bridgelabz.addressbook.models.Person;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserInputs {
      private final Scanner scan = new Scanner(System.in);
      private final String PATTERN = "^[a-zA-Z]{1,}$";


      public Person addPerson() {
            Person person = new Person();
            this.addFirstName(person);
            this.addLastName(person);
            this.addAddress(person);
            this.addCity(person);
            this.addState(person);
            this.addZipCode(person);
            this.addPhoneNumber(person);
            return person;
      }

      public Person addDetails(Person person) {
            boolean flag = true;
            while (flag) {
                  scan.nextLine();
                  int selectField = this.selectFieldToEdit();
                  switch (selectField) {
                        case 1:
                              this.addAddress(person);
                              break;
                        case 2:
                              this.addCity(person);
                              break;
                        case 3:
                              this.addState(person);
                              break;
                        case 4:
                              this.addZipCode(person);
                        case 5:
                              this.addPhoneNumber(person);
                              break;
                        case 6:
                              flag = false;
                              break;
                        default:
                              System.out.println("Please Select valid Input.");
                  }
            }
            return person;
      }

      private boolean validateInput(String input, String validator) {
            Pattern pattern = Pattern.compile(validator);
            if (pattern.matcher(input).matches())
                  return true;
            else
                  System.out.print("Invalid Input. Please Enter Again.\n");
            return false;
      }

      private void addFirstName(Person person) {
            do {
                  System.out.println("Enter your First Name");
                  person.firstName = scan.next();
            } while (!validateInput(person.firstName, PATTERN));
      }

      private void addLastName(Person person) {
            do {
                  System.out.println("Enter your Last Name");
                  person.lastName = scan.next();
            } while (!validateInput(person.lastName, PATTERN));
      }

      private void addAddress(Person person) {
            System.out.println("Enter your Address");
            person.address = scan.next();
            scan.nextLine();
      }

      private void addCity(Person person) {
            do {
                  System.out.println("Enter your City");
                  person.cityName = scan.next();
            } while (!validateInput(person.cityName, PATTERN));
      }

      private void addState(Person person) {
            do {
                  System.out.println("Enter your State");
                  person.stateName = scan.next();
            } while (!validateInput(person.stateName, PATTERN));
      }

      private void addZipCode(Person person) {
            do {
                  System.out.println("Enter your Zip code");
                  person.zipCode = scan.next();
            } while (!validateInput(person.zipCode, "^[1-9][0-9]{5}$"));
      }

      private void addPhoneNumber(Person person) {
            do {
                  System.out.println("Enter your Phone Number");
                  person.mobileNumber = scan.next();
            } while (!validateInput(person.mobileNumber, "^[1-9][0-9]{9}$"));
      }

      public String[] editOrDeleteDetails() {
            System.out.println("Enter your First name");
            String firstName = scan.next();
            System.out.println("Enter your Last name");
            String lastName = scan.next();
            String[] name = {firstName, lastName};
            return name;
      }

      public int sortBy() {
            System.out.println("Press 1: Sort by Name 2: Sort by city 3: Sort by State 4: Sort by zip code");
            int choice_2 = scan.nextInt();
            return choice_2;
      }

      private int selectFieldToEdit() {
            System.out.println("Select field to edit details. \n1: Address \n2: City" +
                    " \n3: State \n4: Zipcode \n5: Phone Number \n6: Save and Exit");
            int select = scan.nextInt();
            return select;
      }

}
