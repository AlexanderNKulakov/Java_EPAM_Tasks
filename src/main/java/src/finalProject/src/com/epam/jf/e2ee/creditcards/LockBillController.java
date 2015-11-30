package com.epam.jf.e2ee.creditcards;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by akulakov on 29.11.2015.
 */
public class LockBillController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request, response);

    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String formBillId = request.getParameter("j_bill_id");
        System.out.println("formBillId = " + formBillId);

        String query = "UPDATE bills set isLock = '1' WHERE id = ?";

        try ( Connection con = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1,formBillId);
            int countRow = preparedStatement.executeUpdate();
            System.out.println("countRow = " + countRow);

        }catch (SQLException e) {
        throw new RuntimeException("SQLException in RegistrationController");
        }

        request.getRequestDispatcher("profile").forward(request, response);

    }
}
