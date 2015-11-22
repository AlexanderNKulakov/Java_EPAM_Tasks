/**
 * Created by akulakov on 13.11.2015.
 */
package com.epam.jf.e2ee.creditcards;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public Controller() +





    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        processRequest(request,response);

    }



    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        System.out.println("I am here!!!");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head>");

        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");

        out.println("<title>Title</title>");

        out.println("</head><body>");

        out.println("<h1> Hello, world!!! </h1>");

        out.println("</body></html>");



    }

}