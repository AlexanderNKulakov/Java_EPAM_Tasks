package com.epam.jf.e2ee.creditcards;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by akulakov on 24.11.2015.
 */
public class DBConnection {

    private static final String DB_URL = "jdbc:mysql://mysql.id1866698.myjino.ru:3306/id1866698_java";
    private static final String DB_USER = "046013672_java";
    private static final String DB_PASSWORD = "sdtr3430";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
