package com.epam.jf.e2ee.creditcards;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by akulakov on 22.11.2015.
 */
public class CardListTableTag extends TagSupport {


    @Override
    public int doStartTag() throws JspException {

        String login =  (String)pageContext.getSession().getAttribute("login");

        String query = "SELECT cardNumber,expDate,billNumber,balance FROM cards, bills WHERE cards.bill_id = bills.id " +
                    "AND bills.user_id = (SELECT id FROM users WHERE login = ?)";

        try  ( Connection connection = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();

            JspWriter out = pageContext.getOut();

            while( resultSet.next() ) {
                    out.write("<tr>");
                    out.write("<td>" + resultSet.getString("cardNumber") + "</td>");
                    out.write("<td>" + resultSet.getString("expDate") + "</td>");
                    out.write("<td>" + resultSet.getString("billNumber") + "</td>");
                    out.write("<td>" + resultSet.getString("balance") + "</td>");
                    out.write("</tr>");
            }
        }catch (SQLException e) {
                throw new RuntimeException("SQLException in CardListTableTag");
        }catch(IOException e){
            throw new JspException(e.getMessage());
        }

        return SKIP_BODY;
    }
}
