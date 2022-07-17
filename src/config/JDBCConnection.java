/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import constand.MySQLConstand;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author nguyen
 */
public class JDBCConnection {

  public static Connection getJDBCConnection() {
    try {
      Class.forName(MySQLConstand.CLASS_NAME);
      Connection conn = DriverManager
          .getConnection(MySQLConstand.URL, MySQLConstand.USER_NAME, MySQLConstand.PASSWORD);
      return conn;
      
    } catch (ClassNotFoundException | SQLException ex) {
        System.out.println("ERROR");
        ex.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    Connection connection = getJDBCConnection();

    if (connection != null) {
      System.out.println("Data connection successful");
    } else {
      System.out.println("Data connection failed");
    }
  }
}
