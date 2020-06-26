package com.bridgelabz.AddressBook.main;
import com.bridgelabz.AddressBook.Utility.Person;
import com.bridgelabz.AddressBook.service.Function;

import java.util.*;
//NOTE: multiple uses of nextLine() have been done
//REASON: scanner does not read enter after the nextInt() so to over come this nextLine() is used multiple times after nextInt()
//main class to choose various options
public class addressBook {
    public static void main(String[] args) {
        ArrayList<Person> arrayReference = new ArrayList<>();
        HashMap<String,String> mapCity= new HashMap<>();
        HashMap<String,String> mapState=new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean endKey = true;
        int count = 0;
        System.out.println("Welcome to Address book");
        System.out.println("Select options from the menu");
        while (endKey) {
            System.out.println("1.Add  2.Edit  3.Delete  4.View  5:Sort  6:Search      9:EXIT");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //code for all the entries to be made ----------------------
                    Person person = Function.addContact();
                    arrayReference.add(person);
                    mapCity.put(person.firstName,person.cityName);
                    break;
                case 2:
                    //code to edit information of a person -------------------------------------------------------
                    sc.nextLine();
                    System.out.println("Edit information ");
                    System.out.println("Enter the first name of the person you would like to edit details about");
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
                    for (Person cont : arrayReference)
                        System.out.println(cont);
                    break;

                case 3:
                    //code to delete a contact -------------------------------------------------------
                    sc.nextLine();
                    System.out.println("Enter the first name of the contact to be deleted");
                    String delete = sc.nextLine();
                    //iterator to iterate through list to find the name and delete it
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
                    //code to view by user choice --------------------------------------
                    System.out.println("1: All contacts 2: By city 3:By state");
                    int choice3 = sc.nextInt();
                    switch (choice3){
                        case 1:
                            //to view all contents of the address book
                            arrayReference.stream().forEach(System.out::println);
                            break;

                        case 2:
                            //to view people and their cities
                            for (Iterator iter = mapCity.entrySet().iterator(); iter.hasNext();) {
                                Map.Entry e = (Map.Entry) iter.next();
                                // prints all the people in map with their corresponding cities
                                System.out.println(e.getKey()+" from "+e.getValue());
                            }
                            break;
                        case 3:
                            //to view people and their staters
                            for (Iterator iter = mapState.entrySet().iterator(); iter.hasNext();) {
                                Map.Entry e = (Map.Entry) iter.next();
                                // printss all the people in map with their corresponding states
                                System.out.println(e.getKey()+" from "+e.getValue());
                            }
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }

                    break;
                case 5:
                    //to sort by various parameters using collections sort method and comparator
                    //comparing data withing the objects using compareTo method and '-' for numeric values
                    Function.sortContact(arrayReference);
                    System.out.println(arrayReference);
                    break;
                case 6:
                    //code to view people from a particular city or state depending on user input
                    System.out.println("Search people");
                    System.out.println("1:By city    2:By state");
                    int choiceFour = sc.nextInt();
                    switch (choiceFour){
                        case 1:
                            sc.nextLine();
                            System.out.println("Enter the name of the city you want to view people from");
                            String search = sc.nextLine();
                            System.out.println("People in "+search+"are");
                            for (Iterator iter = mapCity.entrySet().iterator(); iter.hasNext();) {
                                Map.Entry e = (Map.Entry) iter.next();
                                if (search.equals(e.getValue())) {
                                    // view all the people from user given city in string 'search'
                                    System.out.println(" "+e.getKey());
                                }
                            }
                            break;
                        case 2:
                            sc.nextLine();
                            String searchState = sc.nextLine();
                            System.out.println("People in "+searchState+"are");
                            for (Iterator iter = mapState.entrySet().iterator(); iter.hasNext();) {
                                Map.Entry e = (Map.Entry) iter.next();
                                if (searchState.equals(e.getValue())) {
                                    // view all the people from user given state in string 'searchState'
                                    System.out.println(" "+e.getKey());
                                }
                            }
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
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



