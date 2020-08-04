package com.bridgelabz.addressbook;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.service.AddressBook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
      AddressBook addressBook;
      Person contactOne;
      @Before
      public void setUp(){
            addressBook = new AddressBook();
            contactOne = new Person("Prajyot", "Gajane", "Hno 3", "Margao", "Goa",
                    "403601", "9922542204");
      }

      @Test
      public void givenContact_WhenAddedToContactList_ShouldReturnTrue() {
            addressBook.addContact(contactOne);
            boolean isContactPresent = addressBook.isContactPresent(contactOne);
            Assert.assertTrue(isContactPresent);
      }
}
