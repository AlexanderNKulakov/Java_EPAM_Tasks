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

          String query = "SELECT id FROM users WHERE login  = ? AND password = ?";

          try ( Connection connection = DBConnection.getConnection() ) {


            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2 ,password);

            ResultSet resultSet = preparedStatement.executeQuery();

         //   System.out.println("auth " + resultSet.next());
         //     System.out.println("auth " + resultSet.next());
            return resultSet.next();

        }catch (SQLException e) {
            throw new RuntimeException("SQLException in UserAuth.authenticate()");
        }
    }
}
