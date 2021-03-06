package com.epam.jf.e2ee.creditcards;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * It's used to authenticate the user, set session attributes and forward the user to profile.jsp or admin_profile.jsp
 * Created by akulakov on 19.11.2015.
 */
public class SecurityFilter implements Filter {

  //  private static final Logger log = Logger.getLogger(SecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)

            throws IOException, ServletException {

        System.out.println("SecurityFilter is working");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(true);

        String login = null;
        String password = null;

      //  System.out.println(httpServletRequest.getParameter("j_login"));

        if( session.getAttribute("login") == null) {

            login = httpServletRequest.getParameter("j_login");
            password = httpServletRequest.getParameter("j_password");
        }
        else {
            login = (String)session.getAttribute("login");
            password = (String)session.getAttribute("password");
        }

        String query = "SELECT id,isAdmin FROM users WHERE login  = ? AND password = ?";

        try ( Connection connection = DBConnection.getConnection() ) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if( resultSet.next() ) {
                session.setAttribute("login", login);
                session.setAttribute("password", password);

                // если админ, то пропускаем и перенаправляем
                if( resultSet.getBoolean("isAdmin") ) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    httpServletRequest.getRequestDispatcher("admin_profile").forward(httpServletRequest, httpServletResponse);
                }
                else {
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }
            else {
                httpServletResponse.sendRedirect("login.html");
            }
        }catch (SQLException e) {
            throw new RuntimeException("SQLException in SecurityFilter");
        }

    }

    @Override
    public void destroy() {
    }
}
