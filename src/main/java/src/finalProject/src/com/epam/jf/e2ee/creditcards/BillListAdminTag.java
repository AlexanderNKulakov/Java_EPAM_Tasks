package com.epam.jf.e2ee.creditcards;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.*;

/**
 * Created by akulakov on 01.12.2015.
 */
public class BillListAdminTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {


        String query = "SELECT billNumber,balance,isLock,userName " +
                "FROM bills,users WHERE user_id = users.id";


        try ( Connection connection = DBConnection.getConnection() ) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //   System.out.println(resultSet.next());

            JspWriter out = pageContext.getOut();

            while( resultSet.next() ) {

                out.write("<tr>");

                out.write("<td>" + resultSet.getString("billNumber") + "</td>");
                out.write("<td>" + resultSet.getString("balance") + "</td>");
                out.write("<td>" + resultSet.getString("userName") + "</td>");

                if( resultSet.getBoolean("isLock") ) {
                    out.write("<td>Блокирован</td>");

                    out.write("<td>");
                    out.write("<form action=\"lockBill\" method=\"post\">");
                    out.write("<input name=\"j_bill_id\" type=\"hidden\" value=\"" + resultSet.getString("billNumber") + "\"/>");
                    out.write("<input name=\"j_billoperationtype\" type=\"hidden\" value=\"unlock\"/>");
                    out.write("<input type=\"submit\" value=\"Раблокировать\"/>");
                    out.write("</form>");
                    out.write("</td>");
                }
                else {

                    out.write("<td>Действующий</td>");

                    out.write("<td>");
                    out.write("<form action=\"lockBill\" method=\"post\">");
                    out.write("<input name=\"j_bill_id\" type=\"hidden\" value=\"" + resultSet.getString("billNumber") + "\"/>");
                    out.write("<input name=\"j_billoperationtype\" type=\"hidden\" value=\"lock\"/>");
                    out.write("<input type=\"submit\" value=\"Заблокировать\"/>");
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
