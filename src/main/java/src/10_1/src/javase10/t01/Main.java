package javase10.t01;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://mysql.id1866698.myjino.ru:3306/id1866698_java";
        String user = "046013672_java";
        String password = "sdtr3430";

        Connection con = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    //    try( con = DriverManager.getConnection(url, user, password) ) {
        try {

            con = DriverManager.getConnection(url, user, password);

            Statement statement = con.createStatement();

            String query = "SELECT * FROM users";
            resultSet = statement.executeQuery(query);

            while( resultSet.next())
                System.out.println(resultSet.getString("login") + " " + resultSet.getString("firstName"));

            query = "INSERT INTO users  * FROM users");
            resultSet = statement.executeQuery(query);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
