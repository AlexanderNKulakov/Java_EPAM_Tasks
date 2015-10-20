package javase02.t03;

import static java.lang.System.out;
/**
 * Created by akulakov on 20.10.2015.
 */
public class SimpleOfficeItemSet {
    private Pen pen1;
    private Pen pen2;
    private Pencil pencil;
    private Eraser eraser;
    private Paper paper1;
    private Paper paper2;

    public SimpleOfficeItemSet(Pen pen1, Pen pen2, Pencil pencil, Eraser eraser, Paper paper1, Paper paper2) {
        this.pen1 = pen1;
        this.pen2 = pen2;
        this.pencil = pencil;
        this.eraser = eraser;
        this.paper1 = paper1;
        this.paper2 = paper2;
    }



    public String toString() {
        return "OfficeItemSet includes:\n"
                + "Pen1: " + pen1
                + "\nPen2: " + pen2
                + "\nPencil: " + pencil
                + "\nEraser: " + eraser
                + "\nPaper1: " + paper1
                + "\nPaper2: " + paper2;
    }
}
