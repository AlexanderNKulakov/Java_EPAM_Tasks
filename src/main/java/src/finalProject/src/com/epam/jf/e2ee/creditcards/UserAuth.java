package com.epam.jf.e2ee.creditcards;

import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Created by akulakov on 20.11.2015.
 */
public class UserAuth {

    public static boolean authenticate(String login, String password) {


        if( login == null || password == null ) {
            System.out.println("auth fail, because login or password is null");
            return false;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = null;
        ResultSet resultSet = null;

        String dbUrl = "jdbc:mysql://mysql.id1866698.myjino.ru:3306/id1866698_java";
        String dbUser = "046013672_java";
        String dbPassword = "sdtr3430";

        try {

            con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            Statement statement = con.createStatement();

            String query = "SELECT id FROM users WHERE login  = '" + login + "' AND password = '" + password + "'" ;
            resultSet = statement.executeQuery(query);

            while( resultSet.next())
                System.out.println(resultSet.getString("login") + " " + resultSet.getString("firstName"));



        }catch (SQLException e) {
            e.printStackTrace();
        }
  //      if ( sessionLogin.equals("user1") && password.equals("123") ) {
        if ( login.equals("user1") && password.equals("123") ) {
            System.out.println("auth ok");
            return true;
        }
        else {
            System.out.println("auth fail");
            return false;
        }
    }
}
