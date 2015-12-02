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
 * It's used to lock and unlock the user's bill from the user's or admin's pages
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

        String query = null;

        if( formBillOperationType.equals("lock")) {

            query = "UPDATE bills set isLock = '1' WHERE billNumber = ?";
        }
        else
            if( formBillOperationType.equals("unlock")) {

                query = "UPDATE bills set isLock = '0' WHERE billNumber = ?";
            }
            else {
                request.getRequestDispatcher("error.html").forward(request, response);
                System.out.println("Error in LockBillController: Unknown BillOperationType");
             //   throw new RuntimeException("Unknown BillOperationType");
            }

        try ( Connection con = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1,formBillId);
            int countRow = preparedStatement.executeUpdate();
            System.out.println("LockBillController: countRow = " + countRow);

        }catch (SQLException e) {
            request.getRequestDispatcher("error.html").forward(request, response);
            System.out.println("Error in LockBillController: SQLException");
            // throw new RuntimeException("SQLException in LockBillController");
        }

        // так как может выполнять администратор тоже, чтобы пустить через фильтр, нужно использоваться redirect
        response.sendRedirect("profile");  // так как может выполнять администратор тоже
    }
}
