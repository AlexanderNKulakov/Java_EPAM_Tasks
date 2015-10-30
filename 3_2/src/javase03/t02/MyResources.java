package javase03.t02;

import java.util.ListResourceBundle;

/**
 * Created by akulakov on 28.10.2015.
 */
public class MyResources extends ListResourceBundle {
    public Object[][] getContents() {
        return new Object[][]{
                {"question11", "answer11"},
                {"question22", "answer22"},
                {"question33", "answer33"}
            };
        }
}

