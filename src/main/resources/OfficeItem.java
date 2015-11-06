package javase02.t04;

import java.lang.*;
import java.lang.Cloneable;

/**
 * Created by akulakov on 21.10.2015.
 */

public class OfficeItem implements Comparable<OfficeItem> {
    protected String producerName;
    protected int price;

    public OfficeItem(String producerName, int price) {
        this.producerName = producerName;
        this.price = price;
    }

    public String getProducerName() {
        return producerName;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProducerName=" + producerName + ";Price=" + price;
    }

    @Override
    public int compareTo(OfficeItem anotherOfficeItem) {
        return price-anotherOfficeItem.price;
    }
}
