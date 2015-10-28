package javase03.t01;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        CrazyLogger crazyLogger = new CrazyLogger();

        crazyLogger.addMessage("message1");
        crazyLogger.addMessage("test");
        crazyLogger.addMessage("message2");
        crazyLogger.addMessage("tatata");
        crazyLogger.addMessage("mess456");

        out.println(crazyLogger.searchMessage("message"));

        out.println(crazyLogger.searchMessage(""));


    }
}
