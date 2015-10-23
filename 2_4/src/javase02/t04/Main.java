package javase02.t04;

import static java.lang.System.out;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        List<OfficeItem> listOfficeItem = new ArrayList<OfficeItem>();


        listOfficeItem.add(new Pen("Pilot",70, Color.BLACK));
        listOfficeItem.add(new Pen("Pilot",70, Color.BLACK));
        listOfficeItem.add(new Pen("Parker",250,Color.BLUE));
        listOfficeItem.add(new Pencil("Derwent", 30, PencilRegidity.B));
        listOfficeItem.add(new Pencil("Aero", 30, PencilRegidity.F));
        listOfficeItem.add(new Eraser("Milan", 35, EraserType.VinylEraser));
        listOfficeItem.add(new Paper("Kym",200,PaperSize.A4, 75));
        listOfficeItem.add(new Paper("Kenta",400,PaperSize.A4, 150));

        for(OfficeItem element:listOfficeItem)
            out.println(element);

     //   Collections.sort(listOfficeItem, new OfficeItemComparatorByPrice());
    //    Collections.sort(listOfficeItem, new OfficeItemComparatorByProducerName());
        Collections.sort(listOfficeItem, new OfficeItemComparatorByPriceAndProducerName());
        out.println();

        for(OfficeItem element:listOfficeItem)
            out.println(element);

    }
}
