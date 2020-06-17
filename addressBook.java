package com.bridgelabz.addressBook;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

//main class to choose various options
public class addressBook {
    public static void main(String[] args) {
        ArrayList<Person> arrayReference = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean endKey = true;
        System.out.println("Welcome to Address book");
        System.out.println("Select options from the menu");
        while (endKey) {
            System.out.println("1.Add  2.Edit  3.Delete 4.View 9:Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();
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
                    System.out.println("Enter the mobile number:");
                    long mobileNumber = sc.nextLong();
                    //this reference can be used to store multiple contacts records in array list
                    arrayReference.add(new Person(firstName, lastName, address, cityName, stateName, zipCode, mobileNumber));
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Edit information ");
                    System.out.println("Enter the first name of the person you would like to edit details about");
                    sc.nextLine();
                    String update = sc.nextLine();
                    //iterator to iterate through list
                    for (ListIterator<Person> iter = arrayReference.listIterator(); iter.hasNext(); ) {
                        Person data = iter.next();
                        if (update.equals(data.getRecord())) {
                            System.out.println("Update 1: Address 2:City 3:State 4:Zip code 5: Mobile Number");
                            int choice_2 = sc.nextInt();
                            switch (choice_2) {
                                case 1:
                                    sc.nextLine();
                                    System.out.println("Update new address:");
                                    data.cityName = sc.nextLine();
                                    break;
                                case 2:
                                    System.out.println("Update the city:");
                                    data.cityName = sc.nextLine();
                                    break;
                                case 3:
                                    System.out.println("Update the state");
                                    data.stateName = sc.nextLine();
                                    break;
                                case 4:
                                    System.out.println("Update the mobile zip code");
                                    data.zipCode = sc.nextInt();
                                    break;
                                case 5:
                                    System.out.println("Update the mobile number");
                                    data.mobileNumber = sc.nextLong();
                                default:
                                    System.out.println("Enter valid input");
                                    break;
                            }
                            System.out.println("Contact updated");
                        }
                    }
                    for (Person cont : arrayReference)
                        System.out.println(cont);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter the first name of the contact to be deleted");
                    String delete = sc.nextLine();
                    //iterator to iterate through list
                    for (ListIterator<Person> iter = arrayReference.listIterator(); iter.hasNext(); ) {
                        Person data = iter.next();
                        if (delete.equals(data.getRecord())) {
                            iter.remove();
                        }
                    }
                    System.out.println("Contact deleted");
                    //to display all the contact in the array list after delete
                    for (Person cont : arrayReference)
                        System.out.println(cont);
                    break;
                case 4:
                    for (Person cont : arrayReference)
                        System.out.println(cont);
                    break;
                case 9:
                    endKey=false;
                    break;

                default:
                    System.out.println("Choose valid input");
                    break;
            }
        }
    }
}
//class to store contacts
class Person{
    public String firstName;
    public String lastName;
    public String address;
    public String cityName;
    public String stateName;
    public int zipCode;
    public long mobileNumber;
    Person( String firstName, String lastName,String address, String cityName,String stateName,int zipCode,long
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
        return this.firstName+" "+ this.lastName +" "+ this.cityName +" "+ this.stateName +" "+
                this.zipCode +" "+ this.mobileNumber;
    }
    public String getRecord(){
        return this.firstName;
    }
}


