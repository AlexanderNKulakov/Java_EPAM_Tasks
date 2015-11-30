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

        String query;

        if( formBillOperationType.equals("deposit")) {
            query = "UPDATE bills SET balance = balance + ? WHERE billNumber = ?";
        }
        else
            if(  formBillOperationType.equals("withdraw")) {
                query = "UPDATE bills SET balance = balance - ? WHERE billNumber = ?";
            }
            else {
                throw new RuntimeException("Unknown BillOperationType");
            }

        try ( Connection con = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,Integer.parseInt(formAmount));
            preparedStatement.setString(2,formBillId);
            int countRow = preparedStatement.executeUpdate();
            System.out.println("countRow = " + countRow);

        }catch (SQLException e) {
            throw new RuntimeException("SQLException in ChangeBalanceController");
        }

        //   System.out.println("ChangeBalanceController : forwarding to profile");
        request.getRequestDispatcher("profile").forward(request, response);

    }
}
