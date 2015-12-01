package com.epam.jf.e2ee.creditcards;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by akulakov on 24.11.2015.
 */
public class GetLoginTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        try {

            JspWriter out = pageContext.getOut();

            String login = (String)pageContext.getSession().getAttribute("login");

            if( login == null ) throw new RuntimeException("GetLoginTag: login is null");

            out.write(login);

        }catch(IOException e){
            throw new JspException(e.getMessage());
        }

        return SKIP_BODY;
    }
}
