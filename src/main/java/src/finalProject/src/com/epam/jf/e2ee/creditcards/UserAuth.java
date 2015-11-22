package com.epam.jf.e2ee.creditcards;

import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * Created by akulakov on 20.11.2015.
 */
public class UserAuth {

    private static final String dbUrl = "jdbc:mysql://mysql.id1866698.myjino.ru:3306/id1866698_java";
    private static final String dbUser = "046013672_java";
    private static final String dbPassword = "sdtr3430";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

     public static boolean authenticate(String login, String password) {

        if( login == null || password == null ) {
            System.out.println("auth fail, because login or password is null");
            return false;
        }

        try ( Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword) ) {

             Statement statement = con.createStatement();

            String query = "SELECT id FROM users WHERE login  = '" + login + "' AND password = '" + password + "'" ;

            ResultSet resultSet = statement.executeQuery(query);

        //    System.out.println("auth " + resultSet.next());
            return resultSet.next();

        }catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
