package com.bridgelabz.AddressBook.main;
import com.bridgelabz.AddressBook.utility.Person;
import com.bridgelabz.AddressBook.service.Function;
import java.util.*;
//NOTE: multiple uses of nextLine() have been done
//REASON: scanner does not read enter after the nextInt() so to over come this nextLine() is used multiple times after nextInt()
public class addressBook {
    public static void main(String[] args) {
        ArrayList<Person> arrayReference = new ArrayList<>();
        HashMap<String,String> mapCity= new HashMap<>();
        HashMap<String,String> mapState=new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean endKey = true;
        System.out.println("Welcome to Address book");
        System.out.println("Select options from the menu");
        while (endKey) {
            System.out.println("1.Add  2.Edit  3.Delete  4.View  5:Sort  6:Search      9:EXIT");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //code for all the entries to be made ----------------------
                    Function.addContact(arrayReference, mapCity, mapState);
                    break;
                case 2:
                    Function.editContactDetails(arrayReference);
                    break;
                case 3:
                    Function.deleteContact(arrayReference);
                    break;
                case 4:
                    //code to view by user choice --------------------------------------
                    Function.viewContacts(arrayReference, mapCity, mapState);
                    break;
                case 5:
                    //to sort by various parameters using collections sort method and comparator
                    //comparing data withing the objects using compareTo method and '-' for numeric values
                    Function.sortContact(arrayReference);
                    arrayReference.stream().forEach(System.out::println);
                    break;
                case 6:
                    Function.customPlace(mapCity, mapState);
                    break;
                case 9:
                    //to break the while loop endKey variable is set to false
                    endKey=false;
                    break;
                default:
                    System.out.println("Choose valid input");
                    break;
            }
        }
    }
}