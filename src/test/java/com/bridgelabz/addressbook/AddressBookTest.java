package com.bridgelabz.addressbook;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.service.AddressBook;
import com.bridgelabz.addressbook.dbconnection.DataBaseConnection;
import com.bridgelabz.addressbook.utility.GsonIO;
import com.bridgelabz.addressbook.utility.OpenCSVIO;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class AddressBookTest {
      private AddressBook addressBook;
      private Person contactOne;
      private Connection connection;

      @Before
      public void before() {
            connection = DataBaseConnection.getConnection();
      }

      @After
      public void after() {
            DataBaseConnection.closeConnection(connection);
      }

      private final String ADDRESS_BOOK_FILE_PATH_CSV = "src/main/resources/AddressBookListCSV.csv";
      private final String ADDRESS_BOOK_FILE_PATH_GSON = "src/main/resources/AddressBookListGSON.json";

      @Before
      public void setUp() {
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

      @Test
      public void givenMultipleThread_ShouldRunOneAfterOther() {
            Thread threadOne = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        addressBook.addContact(contactOne);
                        try {
                              Thread.sleep(2000);
                              System.out.println("In thread one");
                        } catch (InterruptedException e) {
                              e.printStackTrace();
                        }
                        addressBook.saveGSONType(new GsonIO(), ADDRESS_BOOK_FILE_PATH_GSON, 1);
                  }
            });
            Thread threadTwo = new Thread(new Runnable() {
                  @Override
                  public void run() {
                        System.out.println("In thread two");
                        addressBook.saveCSVType(new OpenCSVIO(), ADDRESS_BOOK_FILE_PATH_CSV, 2);
                  }
            });
            threadOne.setName("First Thread");
            threadTwo.setName("Second Thread");
            threadOne.start();
            threadTwo.start();
      }

      @Test
      public void givenDatabaseConnection_WhenClosed_ShouldReturnTrue() {
            DataBaseConnection.closeConnection(connection);
            try {
                  Assert.assertTrue(connection.isClosed());
            } catch (SQLException e) {
                  Assert.fail();
            }
      }
}
