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
        String formBillOperationType = request.getParameter("j_billoperationtype");

        String query;

        if( formBillOperationType.equals("lock")) {

            query = "UPDATE bills set isLock = '1' WHERE billNumber = ?";
        }
        else
            if( formBillOperationType.equals("unlock")) {

                query = "UPDATE bills set isLock = '0' WHERE billNumber = ?";
            }
            else {
                throw new RuntimeException("Unknown BillOperationType");
            }

        try ( Connection con = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1,formBillId);
            int countRow = preparedStatement.executeUpdate();
            System.out.println("countRow = " + countRow);

        }catch (SQLException e) {
        throw new RuntimeException("SQLException in LockBillController");
        }

     //   System.out.println("LockBillController : forwarding to profile");
     //   request.getRequestDispatcher("profile").forward(request, response);
        response.sendRedirect("profile");

    }
}
