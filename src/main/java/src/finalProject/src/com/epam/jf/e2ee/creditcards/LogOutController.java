package com.epam.jf.e2ee.creditcards;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by akulakov on 26.11.2015.
 */
public class LogOutController extends HttpServlet {

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

        request.logout();

    //    PrintWriter out = response.getWriter();
   //     out.println("<html><head>");

    //    out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
     //   out.write("Вы вышли");

   //     request.getRequestDispatcher("login.html").forward(request, response);

    }
}
