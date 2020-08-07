package com.bridgelabz.addressbook.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseConnection {
      public static Connection getConnection() {
            Properties properties = new Properties();
            FileInputStream fileInputStream;
            Connection connection = null;
            try {
                  fileInputStream = new FileInputStream("database.properties");
                  properties.load(fileInputStream);
                  connection = DriverManager.getConnection(properties.getProperty("DB_URL"),
                          properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));
            } catch (SQLException | IOException e) {
                  e.printStackTrace();
            }
            return connection;
      }

      public static void closeConnection(Connection connection) {
            try {
                  connection.close();
            } catch (SQLException e) {
                  e.printStackTrace();
            }
      }

      public static void closeStatement(Statement statement) {
            try {
                  statement.close();
            } catch (SQLException e) {
                  e.printStackTrace();
            }
      }
}
