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


    public void setNum(String num) {
        System.out.println("num = " + num);
    }

  //  @Override
    public int doStartTag() throws JspException {

    //    int size = new Integer(set.getSize());

    //    String str = "Size = <b>(" + size + ")</b>";

        try{

            JspWriter out = pageContext.getOut();

       //     out.write(str);

            String login =  (String)pageContext.getSession().getAttribute("login");
       //     String query = "SELECT cardNumber,expDate,billNumber FROM cards INNER JOIN bills using(bill_id) WHERE user_id  = ?";
            String query = "SELECT cardNumber,billNumber,balance,expDate FROM cards INNER JOIN bills using(id) WHERE user_id  = ?";

            try ( Connection connection = DBConnection.getConnection() ) {

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,"1");
                ResultSet resultSet = preparedStatement.executeQuery();
             //   System.out.println(resultSet.next());
                while( resultSet.next() ) {
                    out.write("<tr>");
                    out.write("<td>" + resultSet.getString("cardNumber") + "</td>");
                    out.write("<td>" + resultSet.getString("billNumber") + "</td>");
                    out.write("<td>" + resultSet.getString("balance") + "</td>");
                    out.write("<td>" + resultSet.getString("expDate") + "</td>");
                    out.write("</tr>");
                }
            }catch (SQLException e) {
                throw new RuntimeException("SQLException in CardListTableTag");
            }


         //   HttpSession session = httpServletRequest.getSession(true);
         //   String sessionLogin = (String)session.getAttribute("login");
         //   out.write("На залогинились как " + sessionLogin);

            /*
            for(int i=0; i<size; i++){

                out.write("<tr><td>");

                out.write(set.getElement());

                out.write("</td></tr>");

            }
            */

            out.write("</table>");

        }catch(IOException e){

            throw new JspException(e.getMessage());

        }

        return SKIP_BODY;

    }
}
