package com.epam.jf.e2ee.creditcards;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
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

            if( resultSet.next() ) {   // если пароль верный
                session.setAttribute("login", login);
                session.setAttribute("password", password);
                if( resultSet.getBoolean("isAdmin") ) { // если админ, то пропускаем и перенаправляем
                    filterChain.doFilter(servletRequest, servletResponse);
                    httpServletRequest.getRequestDispatcher("admin_profile").forward(httpServletRequest, httpServletResponse);
               //     System.out.println("SecurityFilter: admin");
                }
                else {
                    filterChain.doFilter(servletRequest, servletResponse);
               //     System.out.println("SecurityFilter: not admin");
                }
            }
            else {
                httpServletRequest.getSession().invalidate();  // если во время сессии был изменен пароль парользователя
           //     httpServletRequest.getRequestDispatcher("login.html").forward(httpServletRequest, httpServletResponse);
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
