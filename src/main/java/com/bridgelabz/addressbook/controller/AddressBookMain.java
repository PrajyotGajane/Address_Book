package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.service.AddressBook;
import com.bridgelabz.addressbook.utility.GsonIO;
import com.bridgelabz.addressbook.utility.JsonSimpleIO;
import com.bridgelabz.addressbook.utility.OpenCSVIO;
import com.bridgelabz.addressbook.utility.UserInputs;

import java.util.Scanner;

public class AddressBookMain {
      public static void main(String[] args) {
            UserInputs userInputs = new UserInputs();
            final String ADDRESS_BOOK_FILE_PATH_JSON = "src/main/resources/AddressBookList.json";
            final String ADDRESS_BOOK_FILE_PATH_CSV = "src/main/resources/AddressBookListCSV.csv";
            final String ADDRESS_BOOK_FILE_PATH_GSON = "src/main/resources/AddressBookListGSON.json";
            JsonSimpleIO jsonSimpleIO = new JsonSimpleIO();
            OpenCSVIO openCSVIO = new OpenCSVIO();
            GsonIO gsonIO = new GsonIO();
            AddressBook addressBook = new AddressBook();
            Scanner sc = new Scanner(System.in);
            boolean endKey = true;
            System.out.println("Welcome to Address book");
            System.out.println("Select options from the menu");
            while (endKey) {
                  System.out.println("1.Add  2.Edit  3.Delete  4.View  5:Sort  6:Search for Person  \n7:Save/Read Json file" +
                          "  8:Save/Read CSV file  9:Save/Read GSON file  10:EXIT");
                  int choice = sc.nextInt();
                  switch (choice) {
                        case 1:
                              addressBook.addContact(userInputs.addPerson());
                              break;
                        case 2:
                              String[] nameToEdit = userInputs.editOrDeleteDetails();
                              addressBook.editContactDetails(nameToEdit[0], nameToEdit[1]);
                              break;
                        case 3:
                              String[] nameToDelete = userInputs.editOrDeleteDetails();
                              addressBook.deleteContact(nameToDelete[0], nameToDelete[1]);
                              break;
                        case 4:
                              addressBook.displayAll();
                              break;
                        case 5:
                              addressBook.sortContact(userInputs.sortBy());
                              break;
                        case 6:
                              String[] nameToSearch = userInputs.editOrDeleteDetails();
                              addressBook.searchPerson(nameToSearch[0], nameToSearch[1]);
                              break;
                        case 7:
                              addressBook.saveJsonType(jsonSimpleIO, ADDRESS_BOOK_FILE_PATH_JSON);
                              break;
                        case 8:
                              addressBook.saveCSVType(openCSVIO, ADDRESS_BOOK_FILE_PATH_CSV, userInputs.saveReadFileToCSV());
                              break;
                        case 9:
                              addressBook.saveGSONType(gsonIO,ADDRESS_BOOK_FILE_PATH_GSON, userInputs.saveReadFileToGson());
                              break;
                        case 10:
                              endKey = false;
                              break;
                        default:
                              System.out.println("Choose valid input");
                              break;
                  }
            }
      }
}
