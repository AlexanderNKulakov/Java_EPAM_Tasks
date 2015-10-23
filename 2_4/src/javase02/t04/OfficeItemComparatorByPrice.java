package javase02.t04;

import java.util.Comparator;

/**
 * Created by akulakov on 23.10.2015.
 */
public class OfficeItemComparatorByPrice implements Comparator<OfficeItem> {
    @Override
    public int compare(OfficeItem officeItem1,OfficeItem officeItem2) {
        return officeItem1.getPrice()-officeItem2.getPrice();
    }
}
