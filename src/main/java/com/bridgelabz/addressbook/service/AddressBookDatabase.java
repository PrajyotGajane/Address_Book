package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.models.Person;
import com.bridgelabz.addressbook.utility.DataBaseConnection;
import com.bridgelabz.addressbook.utility.UserInputs;

import java.sql.*;
import java.util.Scanner;

public class AddressBookDatabase implements IAddressBook {
      private PreparedStatement preparedStatement;
      ResultSet resultSet = null;
      UserInputs userInputs = new UserInputs();

      @Override
      public void addContact(Person person) {
            try (Connection connection = DataBaseConnection.getConnection()) {
                  int columnCounter = 1;
                  preparedStatement = connection.prepareStatement("insert into contacts values(?,?,?,?,?,?)");
                  preparedStatement.setString(columnCounter++, person.firstName + " " + person.lastName);
                  preparedStatement.setString(columnCounter++, person.getAddress());
                  preparedStatement.setString(columnCounter++, person.getCityName());
                  preparedStatement.setString(columnCounter++, person.getStateName());
                  preparedStatement.setString(columnCounter++, person.getZipCode());
                  preparedStatement.setString(columnCounter, person.getMobileNumber());
                  preparedStatement.executeUpdate();
                  preparedStatement.close();
            } catch (SQLException e) {
                  e.printStackTrace();
                  System.out.println("Duplicate Entry");
            }
      }

      public void editContactDetails(String firstName, String lastName) {
            String fullName = firstName + " " + lastName;
            Person person = new Person();

            boolean flag = true;
            try (Connection connection = DataBaseConnection.getConnection()) {
                  while (flag) {
                        int selectField = userInputs.selectFieldToEdit();
                        switch (selectField) {
                              case 1:
                                    userInputs.addAddress(person);
                                    preparedStatement = connection.prepareStatement("UPDATE contacts SET Address = ? WHERE Name = ?");
                                    preparedStatement.setString(1, person.getAddress());
                                    break;
                              case 2:
                                    userInputs.addCity(person);
                                    preparedStatement = connection.prepareStatement("UPDATE contacts SET City = ? WHERE Name = ?");
                                    preparedStatement.setString(1, person.getCityName());
                                    break;
                              case 3:
                                    userInputs.addState(person);
                                    preparedStatement = connection.prepareStatement("UPDATE contacts SET State = ? WHERE Name = ?");
                                    preparedStatement.setString(1, person.getStateName());
                                    break;
                              case 4:
                                    userInputs.addZipCode(person);
                                    preparedStatement = connection.prepareStatement("UPDATE contacts SET Zipcode = ? WHERE Name = ?");
                                    preparedStatement.setString(1, person.getZipCode());
                                    break;
                              case 5:
                                    userInputs.addMobileNumber(person);
                                    preparedStatement = connection.prepareStatement("UPDATE contacts SET Mobile_Number = ? WHERE Name = ?");
                                    preparedStatement.setString(1, person.getMobileNumber());
                                    break;
                              case 6:
                                    flag = false;
                                    break;
                              default:
                                    System.out.println("Please Select valid Input.");
                                    break;
                        }
                        preparedStatement.setString(2, fullName);
                        preparedStatement.executeUpdate();
                        preparedStatement.close();
                  }
            } catch (SQLException e) {
                  System.out.println("Contact does'nt exist");
            }

      }

      @Override
      public void displayAll() {
            try (Connection connection = DataBaseConnection.getConnection()) {
                  preparedStatement = connection.prepareStatement("SELECT * FROM contacts");
                  resultSet = preparedStatement.executeQuery();
                  System.out.println("\nAll contacts in address book");
                  getContactsFromResultSet(resultSet);
                  preparedStatement.close();
            } catch (SQLException e) {
                  e.printStackTrace();
            }
      }

      @Override
      public void deleteContact(String firstName, String lastName) {
            String fullName = firstName + " " + lastName;
            try (Connection connection = DataBaseConnection.getConnection()) {
                  preparedStatement = connection.prepareStatement("DELETE FROM contacts WHERE Name = ?");
                  preparedStatement.setString(1, fullName);
                  preparedStatement.executeUpdate();
                  preparedStatement.close();
                  System.out.println("\nContact Deleted");
            } catch (SQLException e) {
                  System.out.println("Contact does'nt exist");
            }
      }

      @Override
      public void searchPerson(String firstName, String lastName) {
            String fullName = firstName + " " + lastName;
            try (Connection connection = DataBaseConnection.getConnection()) {
                  preparedStatement = connection.prepareStatement("SELECT * FROM contacts WHERE Name = ?");
                  preparedStatement.setString(1, fullName);
                  resultSet = preparedStatement.executeQuery();
                  getContactsFromResultSet(resultSet);
                  preparedStatement.close();
            } catch (SQLException e) {
                  System.out.println("Contact does'nt exist");
            }
      }

      @Override
      public void sortContact(int choice) {
            try (Connection connection = DataBaseConnection.getConnection()) {
                  switch (choice) {
                        case 1:
                              preparedStatement = connection.prepareStatement("SELECT * FROM contacts ORDER BY Name ASC");
                              break;
                        case 2:
                              preparedStatement = connection.prepareStatement("SELECT * FROM contacts ORDER BY City ASC");
                              break;
                        case 3:
                              preparedStatement = connection.prepareStatement("SELECT * FROM contacts ORDER BY State ASC");
                              break;
                        case 4:
                              preparedStatement = connection.prepareStatement("SELECT * FROM contacts ORDER BY Zipcode ASC");
                              break;
                        default:
                              System.out.println("Invalid input");
                              break;
                  }
                  resultSet = preparedStatement.executeQuery();
                  getContactsFromResultSet(resultSet);
                  preparedStatement.close();
            } catch (SQLException e) {
                  System.out.println("Contact does'nt exist");
            }
      }

      private void getContactsFromResultSet(ResultSet resultSet) {
            try {
                  while (resultSet.next()) {
                        String fullName = resultSet.getString("Name");
                        String address = resultSet.getString("Address");
                        String cityName = resultSet.getString("City");
                        String stateName = resultSet.getString("State");
                        String zipCode = resultSet.getString("Zipcode");
                        String mobileNumber = resultSet.getString("Mobile_Number");
                        String printValues = "Name: " + fullName + " \nAddress: " + address + " \nCity: " + cityName + " \nState: " + stateName +
                                " \nZipcode: " + zipCode + " \nMobile Number: " + mobileNumber + "\n";
                        System.out.println(printValues);
                  }
            } catch (SQLException e) {
                  System.out.println("Contact does'nt exist");
            }
      }
}
