package javase02.t04;

/**
 * Created by akulakov on 16.10.2015.
 */
public class Eraser extends OfficeItem {
    private EraserType eraserType;

    public Eraser(String producerName, int price, EraserType eraserType) {
        super(producerName, price);
        this.eraserType = eraserType;
    }

    public String toString() {
        return "Eraser:" + super.toString() + ";EraserType=" + eraserType;
    }
}
