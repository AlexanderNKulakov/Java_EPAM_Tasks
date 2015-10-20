package javase02.t03;

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
        return super.toString() + "; Color: " + color;
    }
}
