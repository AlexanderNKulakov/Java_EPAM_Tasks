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
 * It's used to deposit and withdraw the balance of the user's bill
 * Created by akulakov on 30.11.2015.
 */
public class ChangeBalanceController  extends HttpServlet {

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
        String formAmount = request.getParameter("j_amount");
        String formBillOperationType = request.getParameter("j_billoperationtype");

        String query = null;

        if( formBillOperationType.equals("deposit")) {
            query = "UPDATE bills SET balance = balance + ? WHERE billNumber = ?";
        }
        else
            if(  formBillOperationType.equals("withdraw")) {
                query = "UPDATE bills SET balance = balance - ? WHERE billNumber = ?";
            }
            else {
                request.getRequestDispatcher("error.html").forward(request, response);
                System.out.println("Error in ChangeBalanceController: Unknown BillOperationType");
//                throw new RuntimeException("Unknown BillOperationType");
            }

        try ( Connection con = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,Integer.parseInt(formAmount));
            preparedStatement.setString(2,formBillId);
            int countRow = preparedStatement.executeUpdate();
            System.out.println("ChangeBalanceController: countRow = " + countRow);

        }catch (SQLException e) {
            request.getRequestDispatcher("error.html").forward(request, response);
            System.out.println("Error in ChangeBalanceController: SQLException");
//            throw new RuntimeException("SQLException in ChangeBalanceController");
        }

        request.getRequestDispatcher("profile").forward(request, response);
 //       response.sendRedirect("profile");
    }
}
