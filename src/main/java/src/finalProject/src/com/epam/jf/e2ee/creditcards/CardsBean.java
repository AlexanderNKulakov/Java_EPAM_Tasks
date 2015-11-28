package com.epam.jf.e2ee.creditcards;

/**
 * Created by akulakov on 26.11.2015.
 */
public class CardsBean {

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String[][] getTableLines(){
        return new String[][] { {"Васька", "Петька","ttt","eee"}, {"Ленка","Мишка","hghg","ghh"} };
    }
}
