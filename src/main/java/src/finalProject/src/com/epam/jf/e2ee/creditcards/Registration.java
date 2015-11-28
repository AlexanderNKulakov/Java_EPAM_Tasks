/**
 * Created by akulakov on 13.11.2015.
 */
package com.epam.jf.e2ee.creditcards;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {

    private static final long serialVersionUID = 1L;


  //  public Controller() +

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request,response);

    }



    private void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws  ServletException {

        System.out.println("registration!!!");

        response.setContentType("text/html");

        try {
            PrintWriter out = response.getWriter();
            out.println("<html><head>");

            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");

            out.println("<title>Title</title>");

            out.println("</head><body>");

            out.println("<h1> Hello, world!!! </h1>");

            out.println("</body></html>");
        }
        catch (IOException e) {
            throw new RuntimeException();
        }

        String formRegLogin = request.getParameter("j_login");
        String formRegUsername = request.getParameter("j_username");
        String formRegPassword = request.getParameter("j_password");

        System.out.println("formRegLogin " + formRegLogin);
        System.out.println("formRegUsername " + formRegUsername);
        System.out.println("formRegPassword " + formRegPassword);

        try ( Connection con = DBConnection.getConnection() ) {

            String query = "INSERT INTO users (userName,login,password) VALUES (?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1,formRegUsername);
            preparedStatement.setString(2,formRegLogin);
            preparedStatement.setString(3,formRegPassword);

            int countRow = preparedStatement.executeUpdate();
            System.out.println("countRow = " + countRow);

        }catch (SQLException e) {
             throw new RuntimeException("SQLException in Registration");
        }

        System.out.println("registration after expectuion!!!");

 //       request.getRequestDispatcher("profile").forward(request, response);

  //      out.println("after registation");
        System.out.println("after registation");

    }

}