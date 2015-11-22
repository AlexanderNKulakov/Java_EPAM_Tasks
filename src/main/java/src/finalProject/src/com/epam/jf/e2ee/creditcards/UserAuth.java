package com.epam.jf.e2ee.creditcards;

import javax.servlet.http.HttpSession;

/**
 * Created by akulakov on 20.11.2015.
 */
public class UserAuth {

    public static boolean authenticate(String login, String password) {


       if( login == null || password == null ) {
           System.out.println("auth fail, because login or password is null");
           return false;
       }

  //      if ( sessionLogin.equals("user1") && password.equals("123") ) {
        if ( login.equals("user1") && password.equals("123") ) {
            System.out.println("auth ok");
            return true;
        }
        else {
            System.out.println("auth fail");
            return false;
        }
    }
}
