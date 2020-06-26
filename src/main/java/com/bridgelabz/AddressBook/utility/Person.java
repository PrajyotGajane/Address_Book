package com.bridgelabz.AddressBook.utility;

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
      public String toString(){
            return this.firstName+" "+ this.lastName +" "+ this.address +" "+ this.cityName +" "+ this.stateName +" "+
                    this.zipCode +" "+ this.mobileNumber;
      }
      public String getRecord(){
            return this.firstName;
      }
}