package javase02.t04;

import java.lang.*;
import java.lang.Cloneable;

/**
 * Created by akulakov on 16.10.2015.
 */
public class Pen extends OfficeItem {
    private Color color;

    public Pen(String producerName, int price, Color color) {
        super(producerName,price);
        this.color = color;
    }

    public String toString() {
        return "Pen:" + super.toString() + ";Color=" + color;
    }

}
