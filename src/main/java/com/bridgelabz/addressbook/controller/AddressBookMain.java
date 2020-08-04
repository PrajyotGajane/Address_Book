package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.service.AddressBook;
import com.bridgelabz.addressbook.utility.GsonIO;
import com.bridgelabz.addressbook.utility.JsonSimpleIO;
import com.bridgelabz.addressbook.utility.OpenCSVIO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddressBookMain {
      public static void main(String[] args) {
            AddressBookMain addressBookMain = new AddressBookMain();
            final String ADDRESS_BOOK_FILE_PATH_JSON = "src/main/resources/AddressBookList.json";
            final String ADDRESS_BOOK_FILE_PATH_CSV = "src/main/resources/AddressBookListCSV.csv";
            final String ADDRESS_BOOK_FILE_PATH_GSON = "src/main/resources/AddressBookListGSON.json";
            List<Person> contactsDetailsList = new ArrayList<>();
            JsonSimpleIO jsonSimpleIO = new JsonSimpleIO(contactsDetailsList);
            OpenCSVIO openCSVIO = new OpenCSVIO(contactsDetailsList);
            GsonIO gsonIO = new GsonIO(contactsDetailsList);
            AddressBook addressBook = new AddressBook(contactsDetailsList);
            HashMap<String, String> mapCity = new HashMap<>();
            HashMap<String, String> mapState = new HashMap<>();
            Scanner sc = new Scanner(System.in);
            boolean endKey = true;
            System.out.println("Welcome to Address book");
            System.out.println("Select options from the menu");
            while (endKey) {
                  System.out.println("1.Add  2.Edit  3.Delete  4.View  5:Sort  6:Search  \n7:Save/Read Json file" +
                          "  8:Save/Read CSV file  9:Save/Read GSON file  10:EXIT");
                  int choice = sc.nextInt();
                  switch (choice) {
                        case 1:
                              addressBook.addContact(mapCity, mapState);
                              break;
                        case 2:
                              addressBook.editContactDetails(contactsDetailsList);
                              break;
                        case 3:
                              addressBook.deleteContact();
                              break;
                        case 4:
                              addressBook.viewContacts(mapCity, mapState);
                              break;
                        case 5:
                              addressBook.sortContact();
                              break;
                        case 6:
                              addressBook.customPlace(mapCity, mapState);
                              break;
                        case 7:
                              addressBookMain.saveJsonType(jsonSimpleIO, ADDRESS_BOOK_FILE_PATH_JSON);
                              break;
                        case 8:
                              addressBookMain.saveCSVType(openCSVIO, ADDRESS_BOOK_FILE_PATH_CSV);
                              break;
                        case 9:
                              addressBookMain.saveGSONType(gsonIO,ADDRESS_BOOK_FILE_PATH_GSON);
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

      private void saveGSONType(GsonIO gsonIO, String address_book_file_path_gson) {
            System.out.println("Choose operation for csv file");
            Scanner scanner = new Scanner(System.in);
            boolean endKey = true;
            while (endKey) {
                  System.out.println("1: Gson Read    2: Gson Write     9: Exit");
                  int choice;
                  choice = scanner.nextInt();
                  scanner.nextLine();
                  switch (choice) {
                        case 1:
                              gsonIO.readFromJsonWithGSON(address_book_file_path_gson);
                              break;
                        case 2:
                              gsonIO.writeToJsonWithGSON(address_book_file_path_gson);
                              break;
                        case 9:
                              endKey = false;
                              break;
                        default:
                              System.out.println("Choose valid input");
                              break;
                  }
            }
      }

      private void saveCSVType(OpenCSVIO openCSVIO, String address_book_file_path_csv) {
            System.out.println("Choose operation for csv file");
            Scanner scanner = new Scanner(System.in);
            boolean endKey = true;
            while (endKey) {
                  System.out.println("1: CSV Read    2: CSV Write     9: Exit");
                  int choice;
                  choice = scanner.nextInt();
                  scanner.nextLine();
                  switch (choice) {
                        case 1:
                              openCSVIO.readFromCSVFile(address_book_file_path_csv);
                              break;
                        case 2:
                              openCSVIO.writeToCSVFile(address_book_file_path_csv);
                              break;
                        case 9:
                              endKey = false;
                              break;
                        default:
                              System.out.println("Choose valid input");
                              break;
                  }
            }
      }

      public void saveJsonType(JsonSimpleIO jsonSimpleIO, String filePath) {
            System.out.println("Choose operation for json file");
            Scanner scanner = new Scanner(System.in);
            boolean endKey = true;
            while (endKey) {
                  System.out.println("1: JSON Read    2: JSON Write     9: Exit");
                  int choice;
                  choice = scanner.nextInt();
                  scanner.nextLine();
                  switch (choice) {
                        case 1:
                              jsonSimpleIO.jsonFileReader(filePath);
                              break;
                        case 2:
                              jsonSimpleIO.jsonFileWriter(filePath);
                              break;
                        case 9:
                              endKey = false;
                              break;
                        default:
                              System.out.println("Choose valid input");
                              break;
                  }
            }
      }
}
