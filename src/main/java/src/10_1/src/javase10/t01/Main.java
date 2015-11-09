package javase10.t01;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://mysql.id1866698.myjino.ru:3306/test";
        String user = "046013672_java";
        String password = "sdtr3430";

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try( con = DriverManager.getConnection(url, user, password) ) {
            Statement statement = connect.CreateStatement

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
