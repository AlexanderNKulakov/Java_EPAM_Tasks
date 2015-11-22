package com.epam.jf.e2ee.creditcards;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import javax.servlet.jsp.JspWriter;

import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by akulakov on 22.11.2015.
 */
public class MyJSPTag extends TagSupport {


    public void setNum(String num) {
        System.out.println("num = " + num);
    }

    @Override
    public int doStartTag() throws JspException {

    //    int size = new Integer(set.getSize());

    //    String str = "Size = <b>(" + size + ")</b>";

        try{

            JspWriter out = pageContext.getOut();

       //     out.write(str);

            out.write("<table border=\"1\">");

            out.write("lalala");

            /*
            for(int i=0; i<size; i++){

                out.write("<tr><td>");

                out.write(set.getElement());

                out.write("</td></tr>");

            }
            */

            out.write("</table>");

        }catch(IOException e){

            throw new JspException(e.getMessage());

        }

        return SKIP_BODY;

    }
}
