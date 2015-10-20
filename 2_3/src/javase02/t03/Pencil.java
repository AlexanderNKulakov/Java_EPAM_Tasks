package javase02.t03;

/**
 * Created by akulakov on 16.10.2015.
 */
public class Pencil extends OfficeItem {
    private PencilRegidity regidity;

    public Pencil(String producerName, int price, PencilRegidity regidity) {
        super(producerName, price);
        this.regidity = regidity;
    }

    public String toString() {
        return super.toString() + " PencilRegidity: " + regidity;
    }
}
