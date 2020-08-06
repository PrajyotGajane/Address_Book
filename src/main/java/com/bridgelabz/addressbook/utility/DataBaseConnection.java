package com.bridgelabz.addressbook.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
      public  static Connection getConnection(){
            Properties properties = new Properties();
            FileInputStream fileInputStream = null;
            Connection connection = null;
            try{
                  fileInputStream = new FileInputStream("database.properties");
                  properties.load(fileInputStream);
                  connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                          properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));
            } catch (SQLException | IOException e) {
                  e.printStackTrace();
            }
            return connection;
      }
}
