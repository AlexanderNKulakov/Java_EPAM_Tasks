package javase02.t03;

/**
 * Created by akulakov on 16.10.2015.
 */
public class OfficeItem {
    protected String producerName;
    protected int price;

    public OfficeItem(String producerName, int price) {
        this.producerName = producerName;
        this.price = price;
    }

    public String toString() {
        return "ProducerName: " + producerName + "; Price: " + price;
    }
}
