package javaee01;

/**
 * Created by akulakov on 17.11.2015.
 */
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class ServletCookie extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String cookieKey;

        String cookieValue;

        cookieKey = request.getParameter("cookiekey");

        cookieValue = request.getParameter("cookievalue");

        if ((cookieKey != null) && (cookieValue != null)) {

            Cookie cookie = new Cookie(cookieKey, cookieValue);

            response.addCookie(cookie);

        }

        Cookie[] reqCookie = request.getCookies();

        if (reqCookie != null) {

            for (Cookie c : reqCookie) {

                response.getWriter().println(c.getName() + " - " + c.getValue() + "<br>");
            }

        } else {

            response.getWriter().println("No cookies");

        }

        request.getRequestDispatcher("/index.jsp").include(request, response);

    }

}