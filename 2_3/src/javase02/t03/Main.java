package javase02.t03;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        Pen pen1 = new Pen("Pilot",70, Color.BLACK);
        Pen pen2 = new Pen("Parker",250,Color.BLUE);

        Pencil pencil1 = new Pencil("Derwent", 30, PencilRegidity.B);
        Pencil pencil2 = new Pencil("Derwent", 30, PencilRegidity.F);

        Eraser eraser1 = new Eraser("Milan", 35, EraserType.VinylEraser);

        Paper paper1 = new Paper("KYM",200,PaperSize.A4, 75);
        Paper paper2 = new Paper("KYM",400,PaperSize.A4, 150);

        SimpleOfficeItemSet simpleOfficeItemSet = new SimpleOfficeItemSet(pen1, pen2, pencil1, eraser1, paper1, paper2);

        out.println(simpleOfficeItemSet);
    }
}
