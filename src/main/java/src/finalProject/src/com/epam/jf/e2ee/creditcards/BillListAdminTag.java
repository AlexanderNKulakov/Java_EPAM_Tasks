package com.epam.jf.e2ee.creditcards;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by akulakov on 01.12.2015.
 */
public class BillListAdminTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {


        String query = "SELECT billNumber,balance,isLock " +
                "FROM bills,users WHERE user_id = (SELECT id FROM users WHERE login = ?)";

        
        try ( Connection connection = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            //   System.out.println(resultSet.next());

            JspWriter out = pageContext.getOut();

            while( resultSet.next() ) {

                out.write("<tr>");

                out.write("<td>" + resultSet.getString("billNumber") + "</td>");
                out.write("<td>" + resultSet.getString("balance") + "</td>");

                if( resultSet.getBoolean("isLock") ) {
                    out.write("<td>" + "Блокирован" + "</td>");
                    out.write("<td>" + "Блокирован" + "</td>");
                    out.write("<td>" + "Блокирован" + "</td>");
                }
                else {
                    out.write("<td>");
                    out.write("<form action=\"lockBill\" method=\"post\">");
                    out.write("<input name=\"j_bill_id\" type=\"hidden\" value=\"" + resultSet.getString("billNumber") + "\"/>");
                    out.write("<input type=\"submit\" value=\"Заблокировать\"/>");
                    out.write("</form>");
                    out.write("</td>");

                    out.write("<td>");
                    out.write("<form action=\"changebalance\" method=\"post\">");
                    out.write("<input name=\"j_bill_id\" type=\"hidden\" value=\"" + resultSet.getString("billNumber") + "\"/>");
                    out.write("<input name=\"j_billoperationtype\" type=\"hidden\" value=\"deposit\"/>");
                    out.write("<input name=\"j_amount\" type=\"input\" value=\"1000\"/>");
                    out.write("<input type=\"submit\" value=\"Пополнить\"/>");
                    out.write("</form>");
                    out.write("</td>");

                    out.write("<td>");
                    out.write("<form action=\"changebalance\" method=\"post\">");
                    out.write("<input name=\"j_bill_id\" type=\"hidden\" value=\"" + resultSet.getString("billNumber") + "\"/>");
                    out.write("<input name=\"j_billoperationtype\" type=\"hidden\" value=\"withdraw\"/>");
                    out.write("<input name=\"j_amount\" type=\"input\" value=\"1000\"/>");
                    out.write("<input type=\"submit\" value=\"Оплатить\"/>");
                    out.write("</form>");
                    out.write("</td>");
                }

                out.write("</tr>");
            }
        }catch(IOException e){
            throw new JspException(e.getMessage());
        }catch (SQLException e) {
            throw new RuntimeException("SQLException in CardListTableTag");
        }

        return SKIP_BODY;
    }
}
