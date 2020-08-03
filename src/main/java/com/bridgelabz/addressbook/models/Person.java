package com.bridgelabz.addressbook.models;

import com.opencsv.bean.CsvBindByPosition;

//class for contacts
public class Person {
      @CsvBindByPosition(required = true, position = 1)
      public String firstName;
      public String lastName;
      public String address;
      public String cityName;
      public String stateName;
      public String zipCode;
      public String mobileNumber;

      public Person(String firstName, String lastName, String address, String cityName, String stateName, String zipCode, String
              mobileNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.cityName = cityName;
            this.stateName = stateName;
            this.zipCode = zipCode;
            this.mobileNumber = mobileNumber;
      }

      public String toString() {
            return "Name: " + this.firstName + " " + this.lastName + "\nAddress: " + this.address + "\nCity: " + this.cityName + "\nState: " + this.stateName + "\nZipcode: " +
                    this.zipCode + "\nMobile number: " + this.mobileNumber + "\n";
      }

      public String getName() {
            return this.firstName + " " + this.lastName;
      }

      public String getFirstName() {
            return this.firstName;
      }

      public String getLastName() {
            return this.lastName;
      }

      public String getCityName() {
            return this.cityName;
      }

      public String getStateName() {
            return this.stateName;
      }

      public String getZipCode() {
            return this.zipCode;
      }

      public String getAddress() {
            return this.address;
      }

      public String getMobileNumber() {
            return this.mobileNumber;
      }
}