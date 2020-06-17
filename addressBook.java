package com.bridgelabz.addressBook;

import java.util.ArrayList;
import java.util.Scanner;

//main class to choose various options
public class addressBook {
    public static void main(String[] args) {
        ArrayList<Person> arrayReference = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
	    System.out.println("Welcome to Address book");
        System.out.println("Enter the first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name:");
        String lastName = sc.nextLine();
        System.out.println("Enter the City name:");
        String cityName = sc.nextLine();
        System.out.println("Enter the State name:");
        String stateName = sc.nextLine();
        System.out.println("Enter the zip code:");
        int zipCode = sc.nextInt();
        System.out.println("Enter the mobile number:");
        long mobileNumber = sc.nextLong();
        //this reference can be used to store multiple contacts records in array list
        arrayReference.add(new Person( firstName, lastName, cityName, stateName, zipCode, mobileNumber));
    }
}
//class to store contacts
class Person{
    public String firstName;
    public String lastName;
    public String cityName;
    public String stateName;
    public int zipCode;
    public long mobileNumber;
    Person( String firstName, String lastName,String cityName,String stateName,int zipCode,long
            mobileNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.zipCode = zipCode;
        this.mobileNumber = mobileNumber;
    }
    public String toString(){
        return this.firstName+" "+ this.lastName +" "+ this.cityName +" "+ this.stateName +" "+
                this.zipCode +" "+ this.mobileNumber;
    }
}


