package javase02.t03;

/**
 * Created by akulakov on 19.10.2015.
 */
public class Paper extends OfficeItem {
    private PaperSize papersize;
    private int density;

    public Paper(String producerName, int price, PaperSize papersize, int density) {
        super(producerName, price);
        this.papersize = papersize;
        this.density = density;
    }

    public String toString() {
        return super.toString() + "; PaperSize: " + papersize + "; Density: " + density;
    }
}
