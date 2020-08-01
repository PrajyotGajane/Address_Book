package com.bridgelabz.addressbook.models;
//class for contacts
public class Person{
      public String firstName;
      public String lastName;
      public String address;
      public String cityName;
      public String stateName;
      public int zipCode;
      public long mobileNumber;
      public Person(String firstName, String lastName, String address, String cityName, String stateName, int zipCode, long
              mobileNumber){
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
      public String getName(){
            return this.firstName + " " +this.lastName;
      }
      public String getFirstName() {
            return this.firstName;
      }
      public String getLastName(){
            return this.lastName;
      }
      public String getCityName(){
            return this.cityName;
      }
      public String getStateName(){
            return this.stateName;
      }
      public int getZipCode() {
            return this.zipCode;
      }
}