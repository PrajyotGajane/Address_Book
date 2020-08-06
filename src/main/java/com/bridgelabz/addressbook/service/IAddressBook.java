package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.models.Person;

public interface IAddressBook {
      void addContact(Person personDetails);
      void editContactDetails(String firstName, String lastName);
      void displayAll();
      void deleteContact(String firstName, String lastName);
      void searchPerson(String firstName, String lastName);
      void sortContact(int choice);
}
