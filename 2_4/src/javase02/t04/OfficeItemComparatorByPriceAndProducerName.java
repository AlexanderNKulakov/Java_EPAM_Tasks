package javase02.t04;

import java.util.Comparator;

/**
 * Created by akulakov on 23.10.2015.
 */
public class OfficeItemComparatorByPriceAndProducerName implements Comparator<OfficeItem> {
    @Override
    public int compare(OfficeItem officeItem1,OfficeItem officeItem2) {

        if( officeItem1.getPrice() == officeItem2.getPrice() )
            return officeItem1.getProducerName().compareTo(officeItem2.getProducerName());
        else
            return officeItem1.getPrice()-officeItem2.getPrice();
    }
}
