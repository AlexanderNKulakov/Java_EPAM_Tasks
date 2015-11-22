package javaee01; /**
 * Created by akulakov on 17.11.2015.
 */

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Enumeration;

import javax.servlet.ServletException;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;


public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;



    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        doPost(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession();



        String name;

        String value;



        name = request.getParameter("paramname");

        value = request.getParameter("paramvalue");
        System.out.println("id = " + session.getId() + " name = " + name + " value = " + value);

        if( name!=null && value!=null  ) session.setAttribute(name, value);
   //     session.setAttribute("parametr1", "value1");


        PrintWriter out = response.getWriter();

        Enumeration<String> sessionParams = session.getAttributeNames();

        out.println(session.getId() + "<br/>");

        while(sessionParams.hasMoreElements()) {

            name = sessionParams.nextElement();

            value = (String) session.getAttribute(name);

            out.println(name + " - " + value + "<br/>");

        }


        Cookie[] cookie = request.getCookies();

        for (Cookie cook : cookie){

            out.println(cook.getName() + " - " + cook.getValue());

        }



     //   request.getRequestDispatcher("/index.jsp").include(request, response);

    }

}