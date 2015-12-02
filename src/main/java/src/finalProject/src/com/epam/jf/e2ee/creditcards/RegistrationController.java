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


public class RegistrationController extends HttpServlet {

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

            throws  ServletException, IOException {

        String formRegLogin = request.getParameter("j_login");
        String formRegUsername = request.getParameter("j_username");
        String formRegPassword = request.getParameter("j_password");

        try ( Connection con = DBConnection.getConnection() ) {

            String query = "INSERT INTO users (userName,login,password) VALUES (?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1,formRegUsername);
            preparedStatement.setString(2,formRegLogin);
            preparedStatement.setString(3,formRegPassword);

            int countRow = preparedStatement.executeUpdate();

            request.getSession(true).setAttribute("login", formRegLogin);
            request.getSession(true).setAttribute("password", formRegPassword);
            request.getRequestDispatcher("profile").forward(request, response);
      //      response.sendRedirect("profile");

        }catch (SQLException e) {
            request.getRequestDispatcher("error.html").forward(request, response);
            System.out.println("Error in RegistrationController: SQLException");
            //    throw new RuntimeException("SQLException in RegistrationController");
        }
     }
}