package com.epam.jf.e2ee.creditcards;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        request.getSession().invalidate();
        System.out.println("session is closed");

    //    request.getRequestDispatcher("profile").forward(request, response);
        response.sendRedirect("login.html");

    }
}
