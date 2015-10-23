package javase02.t03;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        List<OfficeItem> listOfficeItem = new ArrayList<OfficeItem>();

        listOfficeItem.add(new Pen("Pilot",70, Color.BLACK));
        listOfficeItem.add(new Pen("Parker",250,Color.BLUE));
        listOfficeItem.add(new Pencil("Derwent", 30, PencilRegidity.B));
        listOfficeItem.add(new Pencil("Derwent", 30, PencilRegidity.F));
        listOfficeItem.add(new Eraser("Milan", 35, EraserType.VinylEraser));
        listOfficeItem.add(new Paper("KYM",200,PaperSize.A4, 75));
        listOfficeItem.add(new Paper("KYM",400,PaperSize.A4, 150));

        out.println(listOfficeItem);
    }
}
