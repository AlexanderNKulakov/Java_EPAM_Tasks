package com.epam.jf.e2ee.creditcards;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * Created by akulakov on 19.11.2015.
 */
public class SecurityFilter implements Filter {

    private static final Logger log = Logger.getLogger(this.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // TODO: проверить логин и пароль
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        HttpSession session = httpServletRequest.getSession(true);
        String sessionLogin = (String)session.getAttribute("login");
        String sessionPassword = (String)session.getAttribute("password");

        if( UserAuth.authenticate(sessionLogin, sessionPassword) ) {

            System.out.println("sessionLogin and sessionPassword are true");
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {

            String formLogin = httpServletRequest.getParameter("j_login");
            String formPassword = httpServletRequest.getParameter("j_password");

            if ( UserAuth.authenticate(formLogin, formPassword) ) {
                session.setAttribute("login", formLogin);
                session.setAttribute("password", formPassword);
                System.out.println("session login and password have been set");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                System.out.println("forward to login.html");
                httpServletRequest.getRequestDispatcher("login.html").forward(httpServletRequest, httpServletResponse);
            }
        }

    }


    @Override
    public void destroy() {
    }
}
